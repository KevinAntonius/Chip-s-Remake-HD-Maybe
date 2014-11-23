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
public class Pool extends Traps{

    /**
     * Konstruktor untuk Pool yang menginisiasi nama object menjadi "Pool".
     */
    public Pool(){
        this.name="Pool";
    }
    
    /**
     * metod untuk mengembalikan Shoes yang pelu untuk melewati ini
     * @return BlueShoes
     */
    @Override
    public Shoes getRequirementShoes() {
        return new BlueShoes();
    }
    
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("waterTrap.jpg");
    }
}
