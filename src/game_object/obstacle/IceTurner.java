/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle;

import game_object.GameObject;
import game_object.Throughable;

/**
 *
 * @author STEVEN
 */
public class IceTurner extends Obstacle implements Throughable{
    private int directionBend;
    public IceTurner(int direction,int x, int y){
        this.directionBend=direction;
        this.setKoordinat(x, y);
        this.setEffect();
    }
    
    
    public int getDirectionBend(){
        return this.directionBend;
    }

    @Override
    public void movingToThisObstacle(GameObject go) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isThroughable() {
       this.canBeThrough=true;
    }
}
