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
public class Finish extends GameObject{
    
    /**
     * Konstruktor untuk Finish yang menginisiasi nama object menjadi "Finish"
     */
    public Finish(){
     this.name="Finish";
        
    }
       @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("Finish.jpg");
    }
}
