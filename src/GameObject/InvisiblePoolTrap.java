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
public class InvisiblePoolTrap  extends FireFloor implements InvisibleTrap{
     /**
     * Konstruktor untuk InvisiblePoolTrap yang menginisiasi nama object menjadi "IPool".
     */
    public InvisiblePoolTrap(){
        this.name="IPool";
    }   
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("Floor.jpg");
    }
    @Override
    public URL setVisible() {
        return getClass().getClassLoader().getResource("waterTrap.jpg");
    }
    
}
