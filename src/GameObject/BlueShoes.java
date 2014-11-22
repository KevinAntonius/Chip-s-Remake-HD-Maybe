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
public class BlueShoes extends Shoes {
    
    /**
     * Konstruktor untuk BlueShoes yang menginisiasi nama object menjadi "Blue Shoes"
     */
    public BlueShoes(){
        this.name="Blue Shoes";
    }
    
   @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("sepatu katak.jpg");
    }
}
