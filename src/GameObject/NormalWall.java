/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class NormalWall extends Wall{

    /**
     * Konstruktor untuk NormalWall yang menginisiasi nama object menjadi "Wall"
     */
    public NormalWall(){
     this.name="Wall";   
    }
    
    /**
     * Metod untuk mengembalikan false karena normal wall tidak akan bisa dibuka
     * @return false :)
     */
    @Override
    public boolean tryOpen() {
        return false;
    }
    
}
