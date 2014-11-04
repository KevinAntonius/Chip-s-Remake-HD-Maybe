/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle.MovingObstacle;

import game_object.GameObject;

/**
 *
 * @author STEVEN
 */
public class Boulder extends MovingObstacle{

    public Boulder(int x, int y){
        this.setKoordinat(x, y);
        this.setEffect();
    }
    
    @Override
    public void movingToThisObstacle(GameObject go) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEffect() {
        this.isMoveable();
    }

    @Override
    public void isMoveable() {
        this.isMoveable();
    }
    
}
