/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GameObject.*;

/**
 *
 * @author STEVEN
 */
public class Controller {
    private Chip chip;
    private World world; 
    private GameObject object;
    private MapIterable maps;
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
           String str =  "";
            if(direction == 2){
                str = "bawah";
            }else if(direction == 4){
                str = "kiri";
            }else if(direction == 6){
                str = "kanan";
            }else if(direction == 8){
                str = "atas";
            }
            chip.move(x,y);
           this.deathCheck();
           
       }
       else{
           this.tryOpenWallOrBarrier(x, y);
       }
    }
    
    private boolean wallCheck(int x, int y){
        return (world.getObjectAt(x,y).getName().equalsIgnoreCase("Wall")||world.getObjectAt(x, y).getName().equalsIgnoreCase("Barrier"));
    }
    
    private boolean deathCheck(){
        GameObject kevin =  world.getObjectAt(chip.getX(), chip.getY());
        if(kevin.getName().equalsIgnoreCase("Fire Floor")){
            chip.dead();
        }else if(kevin.getName().equalsIgnoreCase("Pool")){
            chip.dead();
        }
        return chip.isDead();
    }
    
    private void itemCheck(){
        GameObject steven = world.getObjectAt(chip.getX(),chip.getY());
        if(steven.getName().equalsIgnoreCase("Blue Choes")){
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
    
    private boolean finishCheck(){
        GameObject evan = world.getObjectAt(chip.getX(),chip.getY());
        if(evan.getName().equalsIgnoreCase("Finish")){
            return true;
        }
        return false;
    }
    
    
    private boolean tryOpenWallOrBarrier(int x, int y){
        Wall barrier = (Wall) world.getObjectAt(x,y);
        return barrier.tryOpen();
    }
    
    public Map start(String path){
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
           for(int j=0;j<this.world.getBaris();j++){
               GameObject go=null;
               String tempObject=split[2+i].substring(j, 1);
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
    
    
}
