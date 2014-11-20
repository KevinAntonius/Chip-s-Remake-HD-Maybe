/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import java.net.URL;

/**
 *
 * @author STEVEN
 */
public class Inventory {
    private Shoes[] shoes;
    
    /**
     * Konstruktor untuk Inventory 
     * @param manyShoes banyaknya Shoes yang dapat disimpan
     */
    public Inventory(int manyShoes){
        shoes=new Shoes[manyShoes];
    }
    
    
    /**
     * Metod mengembalikan boolean yang menandakan bahwa di inventory ada Shoes yang diperlukan
     * @param neededShoes Shoes yang diperlukan
     * @return rue jika ada Shoes yang diperlukan, false jika sebaliknya
     */
    public boolean checkIsThere(Shoes neededShoes){
        for(int i=0;i<shoes.length;i++){
            if(shoes[i]!=null){
                if(shoes[i].getName().equalsIgnoreCase(neededShoes.getName())){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metod untuk menambah Shoes ke inventory
     * @param newShoes Shoes yang ditambah ke inventory
     */
    public void addShoes(Shoes newShoes){
        boolean terisi=false;
        for(int i=0;i<shoes.length&&!terisi;i++){
            if(shoes[i]==null){
                this.shoes[i]=newShoes;
                terisi=true;
            }
        }
    }
    
    /**
     * Metod untuk mengembalikan URL dari Shoes sesuai index
     * @param index index Shoes
     * @return mengembalikan URL Shoes, null jika tidak ada Shoe
     */
    public URL sendURLShoe(int index){
        return this.shoes[index].sendURL();
    }
    
    /**
     * Metod untuk mengembalikan panjang array Shoes yang dimiliki inventory
     * @return Panjang array Shoes yang dimiliki inventory
     */
    public int banyakShoes(){
        return this.shoes.length;
    }
}
