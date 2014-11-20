/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class BlueShoes extends Shoes {
    
    /**
     * Konstruktor untuk BlueShoes yang menginisiasi nama object menjadi "Blue Shoes"
     */
    public BlueShoes(){
        this.name="Blue Shoes";
        this.url=getClass().getClassLoader().getResource("sepatu katak.jpg");
    }
}
