/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class Chip {
    private Inventory inventory;
    private String imagePath;
    private int x;
    private int y;
            
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
    public void move(String direction){
        if(direction.equalsIgnoreCase("atas")){
        this.x=x--;
        }
        else if(direction.equalsIgnoreCase("bawah")){
        this.x=x++;
        }
        else if(direction.equalsIgnoreCase("kiri")){
        this.y=y--;
        }
        else if(direction.equalsIgnoreCase("kanan")){
            this.y=y++;
        }
    }
    public String getPath(){
        return this.imagePath;
    }
    public void setPath(String newPath){
        this.imagePath=newPath;
    }
}
