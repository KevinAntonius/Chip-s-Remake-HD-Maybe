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
public class IC extends GameObject{
    public static int totalChip=0;
    
    /**
     * Konstruktor untuk IC yang menginisiasi nama object menjadi "IC".
     * total chip pun akan bertambah.
     */
    public IC(){
        this.name="IC";
        totalChip++;
    }
    
    /**
     * Metod untuk mengurangi IC yang harus diambil
     */
    public void getIC(){
        totalChip--;
    }
    
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("integratedCircuit.jpg");
    }
}
