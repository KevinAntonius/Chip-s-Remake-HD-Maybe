/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class Floor extends GameObject{
    public Floor(){
       this.name="Floor";
        url = getClass().getClassLoader().getResource("Floor.jpg");
    }
}
