/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle.wall;

import game_object.GameObject;
import game_object.Invisible;
import game_object.item.key.Key;

/**
 *
 * @author STEVEN
 */
public class InvisibleWall extends Wall implements Invisible{

    @Override
    public boolean tryOpen(Key key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movingToThisObstacle(GameObject go) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isInvisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
