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
public class World {
    private GameObject[][] object;
    private String[][] mapKode;
    /**
     * Konstruktor World yang menerima parameter banyak baris dan kolom untuk GameObject di World
     * @param x panjang baris
     * @param y panjang kolom
     */
    public World(int x, int y){
        this.object=new GameObject[x][y];
        this.mapKode=new String[x][y];
    }
    
    /**
     * Metod untuk mendapatkan Objek di baris-x dan kolom-y
     * @param x baris
     * @param y kolom
     * @return objek pada baris-x dan kolom-y
     */
    public GameObject getObjectAt(int x,int y){
        return this.object[x][y];
    }
    
    /**
     * Metod untuk mendapatkan baris yang ada di array GameObject
     * @return baris yang ada di array GameObject
     */
    public int getBaris(){
        return this.object.length;
    }
    
    /**
     * Metod untuk mendapatkan kolom yang ada di array GameObject
     * @return kolom yang ada di array GameObject
     */
    public int getKolom(){
        return this.object[0].length;
    }
    
    /**
     * Metod untuk mengeset GameObject di baris-x dan kolom-y dengan GameObject newGO
     * @param x baris
     * @param y kolom
     * @param newGO GameObject yang akan di set ke World
     */
    public void setGameObjectAt(int x, int y, GameObject newGO, String kode){
        object[x][y]=newGO;
        this.mapKode[x][y]=kode;
    }
    
    /**
     * Metod untuk mengembalikan isi kode map
     * @return isi kode map
     */
    public String[][] getIsiMap(){
        return this.mapKode;
    }
    
    /**
     * Metod untuk mengambil kode map di baris x dan kolom y
     * @param x baris
     * @param y kolom
     * @return kode map di baris x dan kolom y
     */
    public String getKodeMapAt(int x, int y){
        return this.mapKode[x][y];
    }
    
    /**
     * metod untuk menghilangkan GameObject di baris-x dan kolom-y 
     * @param x baris
     * @param y kolom
     */
    public void destroyObjectAt(int x, int y){
        object[x][y]=new Floor();
        this.mapKode[x][y]="n";
    }
    
    
    /**
     * Metod untuk mendapatkan URL pada GameObject di baris-x dan kolom-y
     * @param x baris
     * @param y kolom
     * @return URL pada GameObject di baris-x dan kolom-y
     */
    public URL sendURLAtObject(int x, int y){
        return this.object[x][y].sendURL();
    }
}
