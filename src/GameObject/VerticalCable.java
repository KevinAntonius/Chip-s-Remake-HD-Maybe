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
public class VerticalCable extends Traps{
    /**
     * Konstruktor untuk Pool yang menginisiasi nama object menjadi "HCable".
     */
    public VerticalCable(){
        this.name="VCable";
    }
    @Override
    public Shoes getRequirementShoes() {
        return new ElectricShoes();
    }

    @Override
    public URL sendURL() {
        return getClass().getClassLoader().getResource("cable28.jpg");
   }
}
