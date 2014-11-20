/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class FireFloor extends Traps{

    /**
     * Konstruktor untuk FireFloor yang menginisiasi nama object menjadi "Fire Floor"
     */
    public FireFloor(){
        this.name="Fire Floor";
        this.url=getClass().getClassLoader().getResource("lava.jpg");
    }
    
    /**
     * metod untuk mengembalikan Shoes yang pelu untuk melewati ini
     * @return RedShoes
     */
    @Override
    public Shoes getRequirementShoes() {
        return new RedShoes();
    }
    
}
