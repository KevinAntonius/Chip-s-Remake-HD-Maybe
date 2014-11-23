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
public class InvisibleWall extends NormalWall{
   @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("Floor.jpg");
        } 
}
