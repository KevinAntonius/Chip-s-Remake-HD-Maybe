/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class IC extends GameObject{
    public static int totalChip=0;
    
    /**
     * Konstruktor untuk IC yang menginisiasi nama object menjadi "IC"
     */
    public IC(){
        this.name="IC";
        this.url=getClass().getClassLoader().getResource("integratedCircuit.jpg");
        totalChip++;
    }
    
    public void getIC(){
        totalChip--;
    }
}
