/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GameObject.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

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
    public void chipMove(int direction){
        int x=chip.getX();
        int y=chip.getY();
        if(direction == 2){
            x-=1; 
        }else if(direction == 4){
            y-=1;
        }else if(direction == 6){
            y+=1;
        }else if(direction == 8){
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
               }
           }
           
       }
       else{
           if(this.tryOpenWallOrBarrier(x, y)){
               this.world.destroyObjectAt(x, y);
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
        GameObject kevin =  world.getObjectAt(chip.getX(), chip.getY());
        if(kevin!=null){
             if(kevin.getName().equalsIgnoreCase("Fire Floor")||kevin.getName().equalsIgnoreCase("Pool")){
                Traps trap=(Traps) kevin;
                if(!chip.shoesCheck(trap.getRequirementShoes())){
                chip.isDead();
                }  
                return chip.getDead();
            }
        }
            return false;
    }
    private void itemCheck(){
        GameObject steven = world.getObjectAt(chip.getX(),chip.getY());
        if(steven!=null){
            if(steven.getName().equalsIgnoreCase("Blue Shoes")){
                this.chip.getShoes((Shoes)steven);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
            }else if(steven.getName().equalsIgnoreCase("Red Shoes")){
                this.chip.getShoes((Shoes)steven);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
            }else if(steven.getName().equalsIgnoreCase("IC")){
                //pikirin lagi
                IC ic=(IC)steven;
                ic.getIC();
                this.world.destroyObjectAt(chip.getX(),chip.getY());
            }
        }   
    }
    
    private boolean finishCheck(){
        GameObject evan = world.getObjectAt(chip.getX(),chip.getY());
        if(evan!=null){
            if(evan.getName().equalsIgnoreCase("Finish")){
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
       String []split=str.split("\n");
       this.world=new World((Integer.parseInt(split[0])),(Integer.parseInt(split[1])));
       for(int i=0;i<this.world.getKolom();i++){
           int x=i;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int direction = -1;
        if(e.getKeyCode() == KeyEvent.VK_UP){
            direction = 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            direction = 4;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            direction = 6;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            direction = 8;
        }
        this.chipMove(direction);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Map restart(){
        maps=new Level(path);
        MapIterator mapi=maps.newIterator();
        return (Map)mapi.next();
    }
}
