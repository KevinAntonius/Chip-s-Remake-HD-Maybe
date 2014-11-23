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
public class HorizontalCable extends Traps{
    /**
     * Konstruktor untuk Pool yang menginisiasi nama object menjadi "HCable".
     */
    public HorizontalCable(){
        this.name="HCable";
    }
    @Override
    public Shoes getRequirementShoes() {
        return new ElectricShoes();
    }

    @Override
    public URL sendURL() {
        return getClass().getClassLoader().getResource("cable46.jpg");
   }
    
}
