/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle.MovingObstacle.DangerousObstacle;

import game_object.GameObject;

/**
 *
 * @author STEVEN
 */
public class Jet extends DangerousObstacle {
    
    public Jet(int x, int y){
        this.setKoordinat(x, y);
        this.setEffect();
    }   
    @Override
    public void movingToThisObstacle(GameObject go) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setEffect() {
        this.isMoveable();
    }

    @Override
    public void isMoveable() {
        this.isMoveable();
    }
    
}
