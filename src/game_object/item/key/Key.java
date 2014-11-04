/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.item.key;

import game_object.item.Item;

/**
 *
 * @author STEVEN
 */
public abstract class Key extends Item{
    protected String colour;
    public void addKey(){
        this.inStock++;
    }
    
    public String getColour(){
        return this.colour;
    }
}
