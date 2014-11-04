/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.item;

import game_object.GameObject;
import game_object.Throughable;
import game_object.Useable;
import game_object.chip.Chip;

/**
 *
 * @author STEVEN
 */
public abstract class Item extends GameObject implements Useable,Throughable{
    protected int inStock=0;
    public Chip owner=null;
    
    public abstract boolean usedItem();
    
    public int getInStock(){
        return this.inStock;
    }
    
    public void setOwner(Chip chip){
        this.owner=chip;
    }
    
}
