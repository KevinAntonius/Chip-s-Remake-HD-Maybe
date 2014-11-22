/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import java.awt.Image;
import java.net.URL;

/**
 *
 * @author STEVEN
 */
public class Chip {
    private Inventory inventory=new Inventory(2);
    private String imagePath;
    private boolean death;
    private int x;
    private int y;
    private URL downStandURL;
    private URL leftStandURL;
    private URL upStandURL;
    private URL rightStandURL;
    private URL currentURL;
            
    public Chip(int x, int y){
        this.x=x;
        this.y=y;
        this.death=false;
        this.downStandURL = getClass().getClassLoader().getResource("downStand.png");
        this.leftStandURL = getClass().getClassLoader().getResource("leftStand.png");
        this.rightStandURL = getClass().getClassLoader().getResource("rightStand.png");
        this.upStandURL = getClass().getClassLoader().getResource("upStand.png");
        this.currentURL=downStandURL;
    }
    
    public void moveUp(){
        this.currentURL=this.upStandURL;
        this.x--;
    }
    
    public void moveDown(){
        this.currentURL=this.downStandURL;
        this.x++;
    }
    
    public void moveLeft(){
        this.currentURL=this.leftStandURL;
        this.y--;
    }
    
    public void moveRight(){
        this.currentURL=this.rightStandURL;
        this.y++;
    }
    public String getPath(){
        return this.imagePath;
    }
    public void setPath(String newPath){
        this.imagePath=newPath;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public boolean getDead(){
        return this.death;
    }
    
    /**
     * Metod untuk mengeset Chip untuk mati
     */
    public void isDead(){
        this.death=true;
    }
    
    public void getShoes(Shoes shoe){
        if(shoe!=null){
            this.inventory.addShoes(shoe);
        }
    }
    
    public boolean shoesCheck(Shoes requirementShoes){
        return this.inventory.checkIsThere(requirementShoes);
    }
    
    public URL sendCurrentURL(){
        return this.currentURL;
    }
}
