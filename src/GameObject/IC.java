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
    public IC(){
        this.name="IC";
        totalChip++;
    }
    
    public void getIC(){
        totalChip--;
    }
}
