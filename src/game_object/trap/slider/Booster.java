/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.trap.slider;

/**
 *
 * @author STEVEN
 */
public class Booster extends Slider{
    private int directionBendTo=0;
    public Booster(int direction){
        this.directionBendTo=direction;
    }
}
