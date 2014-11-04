/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle;

import game_object.GameObject;
import game_object.chip.Chip;

/**
 *
 * @author STEVEN
 */
public abstract class Obstacle extends GameObject{
    protected Chip chip=null;
    public abstract void movingToThisObstacle(GameObject go);
}
