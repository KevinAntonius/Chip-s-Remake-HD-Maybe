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
public class InvisibleFireFloor extends FireFloor implements InvisibleTrap{
    /**
     * Konstruktor untuk InvisibleFireFloor yang menginisiasi nama object menjadi "IFire Floor".
     */
    public InvisibleFireFloor(){
        this.name="IFire Floor";
    }   
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("Floor.jpg");
    }
    @Override
    public URL setVisible() {
        return getClass().getClassLoader().getResource("lava.jpg");
    }
    
}
