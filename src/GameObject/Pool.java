/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class Pool extends Traps{

    /**
     * Konstruktor untuk Pool yang menginisiasi nama object menjadi "Pool"
     */
    public Pool(){
        this.name="Pool";
        this.url=getClass().getClassLoader().getResource("waterTrap.jpg");
    }
    
    /**
     * metod untuk mengembalikan Shoes yang pelu untuk melewati ini
     * @return BlueShoes
     */
    @Override
    public Shoes getRequirementShoes() {
        return new BlueShoes();
    }
    
}
