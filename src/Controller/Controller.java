/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GameObject.*;
import Viewer.WorldViewer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author STEVEN
 */
public class Controller implements KeyListener{
    private Chip chip;
    private World world; 
    private GameObject object;
    private MapIterable maps;
    private boolean gameFinish;
    private String path;
    private WorldViewer chips;
    private String isiMap;
    public void chipMove(int direction) throws IOException{
        int x=chip.getX();
        int y=chip.getY();
        if(direction == 8){
            x-=1; 
        }else if(direction == 4){
            y-=1;
        }else if(direction == 6){
            y+=1;
        }else if(direction == 2){
            x+=1;
        }
        if(!this.wallCheck(x,y)){
            if(direction == 2){
                chip.moveDown();
            }else if(direction == 4){
                chip.moveLeft();
            }else if(direction == 6){
                chip.moveRight();
            }else if(direction == 8){
                chip.moveUp();
            }
            System.out.println(this.chip.getX()+" "+this.chip.getY());
            System.out.println(this.getGameObjectAt(this.chip.getX(), this.chip.getY()).getName());
       
           //chip.move(x,y);
           this.deathCheck();
           this.itemCheck();
           if(this.finishCheck()){
               Map newMap=this.nextLevel();
               if(newMap==null){
                   this.gameFinish=true;
               }
               else{
                  this.implementsMapToWorld(newMap);
                  this.chips.fillContent();
                  this.chips.moved();
               }
           }
           
       }
       else{
           if(this.tryOpenWallOrBarrier(x, y)){
               this.world.destroyObjectAt(x, y);
               this.chips.afterTaken(x,y);
           }
       }
    }
    
    private boolean wallCheck(int x, int y){
        if(world.getObjectAt(x,y)==null){
            return false;
        }
        return (world.getObjectAt(x,y).getName().equalsIgnoreCase("Wall")||world.getObjectAt(x, y).getName().equalsIgnoreCase("Barrier"));
    }
    
    private boolean deathCheck(){
        GameObject go =  world.getObjectAt(chip.getX(), chip.getY());
        if(go!=null){
             if(go.getName().equalsIgnoreCase("Fire Floor")||go.getName().equalsIgnoreCase("Pool")){
                Traps trap=(Traps) go;
                if(!chip.shoesCheck(trap.getRequirementShoes())){
                chip.isDead();
                }  
                return chip.getDead();
            }
        }
            return false;
    }
    private void itemCheck() throws IOException{
        GameObject go = world.getObjectAt(chip.getX(),chip.getY());
        if(go!=null){
            if(go.getName().equalsIgnoreCase("Blue Shoes")){
                this.chip.getShoes((Shoes)go);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.chips.afterTaken(chip.getX(),chip.getY());
            }else if(go.getName().equalsIgnoreCase("Red Shoes")){
                this.chip.getShoes((Shoes)go);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.chips.afterTaken(chip.getX(),chip.getY());
            }else if(go.getName().equalsIgnoreCase("IC")){
                //pikirin lagi
                IC ic=(IC)go;
                ic.getIC();
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.chips.afterTaken(chip.getX(),chip.getY());
            }
        }   
    }
    
    private boolean finishCheck(){
        GameObject go = world.getObjectAt(chip.getX(),chip.getY());
        if(go!=null){
            if(go.getName().equalsIgnoreCase("Finish")){
                return true;
            }
        }
        return false;
    }
    
    
    private boolean tryOpenWallOrBarrier(int x, int y){
        Wall barrier = (Wall) world.getObjectAt(x,y);
        return barrier.tryOpen();
    }
    
    public Map start(String path){
        this.path=path;
        maps=new Level(path);
        MapIterator mapi=maps.getIterator();
        return (Map)mapi.next();
    }
    
    private Map nextLevel(){
        return (Map)this.maps.getIterator().next();
    }
    
   public void implementsMapToWorld(Map newMap){
       String str=newMap.getIsiMap();
       this.isiMap=str.substring(6);
       String []split=str.split("\n");
       this.world=new World((Integer.parseInt(split[0])),(Integer.parseInt(split[1])));
       for(int i=0;i<this.world.getKolom();i++){
           for(int j=0;j<this.world.getBaris();j++){
               GameObject go=null;
               String tempObject="";
               if(j==this.world.getBaris()-1){
                   tempObject=split[2+i].substring(j);
               }
               else{
                    tempObject=split[2+i].substring(j, j+1);
               }
               if(tempObject.equalsIgnoreCase("w")){
                   go=new NormalWall();
               }
               else if(tempObject.equalsIgnoreCase("i")){
                   go=new IC();
               }
               else if(tempObject.equalsIgnoreCase("f")){
                   go=new FireFloor();
               }
               else if(tempObject.equalsIgnoreCase("p")){
                   go=new Pool();
               }
               else if(tempObject.equalsIgnoreCase("m")){
                   go=new RedShoes();
               }
               else if(tempObject.equalsIgnoreCase("r")){
                   go=new BlueShoes();
               }
               else if(tempObject.equalsIgnoreCase("b")){
                   go=new Barrier();
               }
               else if(tempObject.equalsIgnoreCase("s")){
                   go=new Finish();
               }
               else if(tempObject.equalsIgnoreCase("c")){
                   go=new Floor();
                   this.chip=new Chip(i,j);
               }
               else if(tempObject.equalsIgnoreCase("n")){
                   go=new Floor();
               }
               this.world.setGameObjectAt(i, j, go);
               
           }
       }
   }
   
   public GameObject getGameObjectAt(int x, int y){
       return this.world.getObjectAt(x, y);
   }
   
   public Chip getChip(){
       return this.chip;
   }
   
   public URL sendURLChip(){
       return this.chip.sendDownStandURL();
   }
   /**
     * Metod untuk mengeset URL pada GameObject di baris-x dan kolom-y
     * @param x baris
     * @param y kolom 
     * @param URL URL baru
     */
    public void setURLAtObject(int x, int y,String URL){
        this.world.setURLAtObject(x, y, URL);
    }
    
    
    /**
     * Metod untuk mendapatkan URL pada GameObject di baris-x dan kolom-y
     * @param x baris
     * @param y kolom
     * @return URL pada GameObject di baris-x dan kolom-y
     */
    public URL sendURLAtObject(int x, int y){
        return this.world.sendURLAtObject(x, y);
    }
    

    public boolean getGameFinish(){
        return this.gameFinish;
    }

    /**
     * 
     * @return 
     */
    public World getWorld(){
        return this.world;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int direction = -1;
        if(e.getKeyCode() == KeyEvent.VK_UP){
            direction = 8;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            direction = 4;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            direction = 6;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            direction = 2;
        }
        try {
            this.chipMove(direction);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.chips.moved();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public Map restart(){
        maps=new Level(path);
        MapIterator mapi=maps.newIterator();
        return (Map)mapi.next();
    }
    
    public void implementsWorldViewer(WorldViewer worldV){
        this.chips = worldV;
    }
    
    public String[][] getIsiMap(){
        String [][] arrayMap=new String[this.world.getBaris()][this.world.getKolom()];
        String []splitBaris=this.isiMap.split("\n");
        for(int i=0;i<splitBaris.length;i++){
            for(int j=0;j<splitBaris[i].length();j++){
                arrayMap[i][j]=splitBaris[i].substring(j, j+1);
            }
        }
        return arrayMap;
    }
    
    public String kodeTipeGameObjekDiMapSekarang(){
        String str="";
        String[][] arrayMap=this.getIsiMap();
        for(int i=0;i<arrayMap.length;i++){
            for(int j=0;j<arrayMap[i].length;j++){
                if(str.equalsIgnoreCase("")){
                    str+=""+arrayMap[i][j];
                }
                else{
                    if(!this.checkExistChar(str, arrayMap[i][j])){
                        if(!arrayMap[i][j].equalsIgnoreCase("c")){
                            str=str+arrayMap[i][j];
                        }
                    }
                }
            }
        }
        return str;
    }
    
    private boolean checkExistChar(String str, String newString){
        boolean exist=false;
        for(int i=0;i<str.length()&&!exist;i++){
            if(str.substring(i, i+1).equalsIgnoreCase(newString)){
                exist=true;
            }
        }
        return exist;
    }
    
    public GameObject[] tipeGameObjectDiMapSekarang(){
        String str=this.kodeTipeGameObjekDiMapSekarang();
        GameObject[] gos=new GameObject[str.length()];
        GameObject temp;
        String tempKode;
        for(int i=0;i<gos.length;i++){
            tempKode=str.substring(i, i+1);
            if(tempKode.equalsIgnoreCase("w")){
                temp=new NormalWall();
            }
            else if(tempKode.equalsIgnoreCase("m")){
                temp=new RedShoes();
            }
            else if(tempKode.equalsIgnoreCase("f")){
                temp=new FireFloor();
            }
            else if(tempKode.equalsIgnoreCase("i")){
                temp=new IC();
            }
            else if(tempKode.equalsIgnoreCase("p")){
                temp=new Pool();
            }
            else if(tempKode.equalsIgnoreCase("b")){
                temp=new Barrier();
            }
            else if(tempKode.equalsIgnoreCase("r")){
                temp=new BlueShoes();
            }
            else if(tempKode.equalsIgnoreCase("s")){
                temp=new Finish();
            }
            else {
                temp=new Floor();
            }
            gos[i]=temp;
        }
        return gos;
    }
}
