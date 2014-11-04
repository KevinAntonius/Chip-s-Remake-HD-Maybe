/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.obstacle.wall;

import game_object.item.key.Key;
import game_object.obstacle.Obstacle;

/**
 *
 * @author STEVEN
 */
public abstract class Wall extends Obstacle{

    public abstract boolean tryOpen(Key key);
}
