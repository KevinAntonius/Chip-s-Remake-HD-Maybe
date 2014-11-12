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
    
}
