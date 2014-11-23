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
public class FireFloor extends Traps{

    /**
     * Konstruktor untuk FireFloor yang menginisiasi nama object menjadi "Fire Floor".
     */
    public FireFloor(){
        this.name="Fire Floor";
    }
    
    /**
     * metod untuk mengembalikan Shoes yang pelu untuk melewati ini
     * @return RedShoes
     */
    @Override
    public Shoes getRequirementShoes() {
        return new RedShoes();
    }
    
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("lava.jpg");
    }
}
