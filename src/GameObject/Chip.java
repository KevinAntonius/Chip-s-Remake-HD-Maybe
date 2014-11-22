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
    private boolean death;
    private int x;
    private int y;
    private URL downStandURL;
    private URL leftStandURL;
    private URL upStandURL;
    private URL rightStandURL;
    private URL currentURL;
    
    /**
     * Konstruktor Untuk menginisialisasi baris dan kolom yang ada di Chip. Selain itu, isinya juga mengeinisialisasi URL yang diperlukan
     * @param x baris
     * @param y kolom
     */
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
    
    /**
     * Metod untuk mengurangi baris yang ditempati chip dan menginisialisasi currentURL menjadi upStandURL
     */
    public void moveUp(){
        this.currentURL=this.upStandURL;
        this.x--;
    }
    
    /**
     * Metod untuk mengurangi baris yang ditempati chip dan menginisialisasi currentURL menjadi downStandURL
     */
    public void moveDown(){
        this.currentURL=this.downStandURL;
        this.x++;
    }
    
    /**
     * Metod untuk mengurangi baris yang ditempati chip dan menginisialisasi currentURL menjadi leftStandURL
     */
    public void moveLeft(){
        this.currentURL=this.leftStandURL;
        this.y--;
    }
    
    /**
     * Metod untuk mengurangi baris yang ditempati chip dan menginisialisasi currentURL menjadi rightStandURL
     */
    public void moveRight(){
        this.currentURL=this.rightStandURL;
        this.y++;
    }
    
    /**
     * Mengembalikan posisi baris dari Chip
     * @return posisi baris dari Chip
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Mengembalikan posisi kolom dari Chip
     * @return posisi kolom dari Chip
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Mengembalikan status kematian dari Chip
     * @return true jika meninggal, false jika masih hidup.
     */
    public boolean getDead(){
        return this.death;
    }
    
    /**
     * Metod untuk mengeset Chip untuk mati
     */
    public void isDead(){
        this.death=true;
    }
    
    /**
     * Metod untuk mendapatkan shoes sesuai di parameter
     * @param shoe 
     */
    public void getShoes(Shoes shoe){
        if(shoe!=null){
            this.inventory.addShoes(shoe);
        }
    }
    
    /**
     * Metod untuk mengecheck apakah ada tipe Shoes yang sesuai dengan parameter
     * @param requirementShoes shoes yang diperlukan
     * @return true jika ada, false jika tidak
     */
    public boolean shoesCheck(Shoes requirementShoes){
        return this.inventory.checkIsThere(requirementShoes);
    }
    
    /**
     * Metod untuk mengembalikan currentURL
     * @return currentURL
     */
    public URL sendCurrentURL(){
        return this.currentURL;
    }
    
    /**
     * Mengubah URL di chip menjadi berdiri diatas lava
     */
    public void setToLavaWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("moveDownStandOnLava.jpg");
        this.leftStandURL = getClass().getClassLoader().getResource("moveLeftStandOnLava.jpg");
        this.rightStandURL = getClass().getClassLoader().getResource("moveRightStandOnLava.jpg");
        this.upStandURL = getClass().getClassLoader().getResource("moveUpStandOnLava.jpg");
    }
    
    /**
     * Mengubah URL di chip menjadi berdiri diatas air
     */
    public void setToWaterWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("moveDownStandOnWaterTrap.jpg");
        this.leftStandURL = getClass().getClassLoader().getResource("moveLeftStandOnWaterTrap.jpg");
        this.rightStandURL = getClass().getClassLoader().getResource("moveRightStandOnWaterTrap.jpg");
        this.upStandURL = getClass().getClassLoader().getResource("moveUpStandOnWaterTrap.jpg");
    }
    
    /**
     * Mengubah URL di chip menjadi berdiri diatas lantai
     */
    public void setToNormalWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("downStand.png");
        this.leftStandURL = getClass().getClassLoader().getResource("leftStand.png");
        this.rightStandURL = getClass().getClassLoader().getResource("rightStand.png");
        this.upStandURL = getClass().getClassLoader().getResource("upStand.png");
   }
}
