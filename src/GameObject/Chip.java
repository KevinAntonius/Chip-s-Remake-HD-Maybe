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
        this.downStandURL = getClass().getClassLoader().getResource("downStand.jpg");
        this.leftStandURL = getClass().getClassLoader().getResource("leftStand.jpg");
        this.rightStandURL = getClass().getClassLoader().getResource("rightStand.jpg");
        this.upStandURL = getClass().getClassLoader().getResource("upStand.jpg");
    }
    /**
     * metod untuk Chip berjalan 
     * Jika:
     * <ul>
     * <li>direction=atas, kordinat x dikurang</li>
     * <li>direction=bawah, kordinat x ditambah</li>
     * <li>direction=kiri, kordinat y dikurang</li>
     * <li>direction=kanan, kordinat y ditambah</li>
     * </ul>
     * @param direction arah pemain
     */
    public void move(int x, int y){
//        if(direction.equalsIgnoreCase("atas")){
//        this.x=x--;
//        }
//        else if(direction.equalsIgnoreCase("bawah")){
//        this.x=x++;
//        }
//        else if(direction.equalsIgnoreCase("kiri")){
//        this.y=y--;
//        }
//        else if(direction.equalsIgnoreCase("kanan")){
//            this.y=y++;
//        }
        if(x>this.x){
            this.currentURL=this.downStandURL;
        }
        else if(x<this.x){
            this.currentURL=this.upStandURL;
        }
        else if(y>this.y){
            this.currentURL=this.rightStandURL;
        }
        else if(y<this.y){
            this.currentURL=this.leftStandURL;
        }
        
        this.x=x;
        this.y=y;
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
        this.currentURL=this.sendRightStandURL();
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
    
    public URL sendDownStandURL(){
        return this.downStandURL;
    }
    
    public URL sendUpStandURL(){
        return this.upStandURL;
    }
    
    public URL sendLeftStandURL(){
        return this.leftStandURL;
    }
    
    public URL sendRightStandURL(){
        return this.rightStandURL;
    }
}
