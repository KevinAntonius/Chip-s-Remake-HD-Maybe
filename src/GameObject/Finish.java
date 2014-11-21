/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class Finish extends GameObject{
    
    /**
     * Konstruktor untuk Finish yang menginisiasi nama object menjadi "Finish"
     */
    public Finish(){
     this.name="Finish";
     this.url=getClass().getClassLoader().getResource("Finish.jpg");
        
    }
}
