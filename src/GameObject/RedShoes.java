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
public class RedShoes extends Shoes{
    
    /**
     * Konstruktor untuk RedShoes yang menginisiasi nama object menjadi "Red Shoes"
     */
    public RedShoes(){
        this.name="Red Shoes";
    }
    
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("redShoes.jpg");
    }
}
