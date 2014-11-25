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
    /**
     * Atribut inventory yang menyimpan Shoes dan selalu tersedia 2 tempat
     */
    private Inventory inventory=new Inventory(2);
    
    /**
     * Atribut yang menandakan apakah chip meninggal atau tidak
     */
    private boolean death;
    
    /**
     * Baris di mana chip berada
     */
    private int x;
    
    /**
     * Kolom di mana chip berada
     */
    private int y;
    
    /**
     * URL saat chip menghadap ke bawah
     */
    private URL downStandURL;
    
    /**
     * URL saat chip menghadap ke kiri
     */
    private URL leftStandURL;
    
    /**
     * URL saat chip menghadap ke atas
     */
    private URL upStandURL;
    
    /**
     * URL saat chip menghadap ke kanan
     */
    private URL rightStandURL;
    
    /**
     * URL arah chip sekarang
     */
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
     * @param shoe Shoes yang diambil
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
     * Metod untuk mengubah URL di chip menjadi berdiri diatas lava
     */
    public void setToLavaWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("moveDownStandOnLava.png");
        this.leftStandURL = getClass().getClassLoader().getResource("moveLeftStandOnLava.png");
        this.rightStandURL = getClass().getClassLoader().getResource("moveRightStandOnLava.png");
        this.upStandURL = getClass().getClassLoader().getResource("moveUpStandOnLava.png");
    }
    
    /**
     * Metod untuk mengubah URL di chip menjadi berdiri diatas air
     */
    public void setToWaterWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("moveDownStandOnWaterTrap.png");
        this.leftStandURL = getClass().getClassLoader().getResource("moveLeftStandOnWaterTrap.png");
        this.rightStandURL = getClass().getClassLoader().getResource("moveRightStandOnWaterTrap.png");
        this.upStandURL = getClass().getClassLoader().getResource("moveUpStandOnWaterTrap.png");
    }
    
    /**
     * Metod untuk mengubah URL di chip menjadi berdiri diatas lantai
     */
    public void setToNormalWalker(){
        this.downStandURL = getClass().getClassLoader().getResource("downStand.png");
        this.leftStandURL = getClass().getClassLoader().getResource("leftStand.png");
        this.rightStandURL = getClass().getClassLoader().getResource("rightStand.png");
        this.upStandURL = getClass().getClassLoader().getResource("upStand.png");
   }
    /**
     * Metod untuk mengubah URL di chip menjadi berdiri diatas air
     */
    public void setToNoLeg(){
        this.downStandURL = getClass().getClassLoader().getResource("chipNoLegDownStand.png");
        this.leftStandURL = getClass().getClassLoader().getResource("chipNoLegLeftStand.png");
        this.rightStandURL = getClass().getClassLoader().getResource("chipNoLegRightStand.png");
        this.upStandURL = getClass().getClassLoader().getResource("chipNoLegUpStand.png");
    }
    
    /**
     * Metod untuk mengubah currentURL ke leftStandURL
     */
    public void setToLeft(){
        this.currentURL=this.leftStandURL;
    }
    /**
     * Metod untuk mengubah currentURL ke rightStandURL
     */
    public void setToRight(){
        this.currentURL=this.rightStandURL;
    }
    /**
     * Metod untuk mengubah currentURL ke upStandURL
     */
    public void setToUp(){
        this.currentURL=this.upStandURL;
    }
    /**
     * Metod untuk mengubah currentURL ke downStandURL
     */
    public void setToDown(){
        this.currentURL=this.downStandURL;
    }
}
