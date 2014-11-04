/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.item;

import game_object.chip.Chip;

/**
 *
 * @author STEVEN
 */
public class IC extends Item{
    
    public IC(Chip owner){
        this.owner=owner;
    }
    
    public IC(int x, int y){
        this.inStock=1;
        this.setKoordinat(x, y);
    }
    
    @Override
    public boolean usedItem() {
      return false;
    }

    @Override
    public void isUseable() {
        this.canBeUse=true;
    }

    @Override
    public void isThroughable() {
        this.canBeThrough=true;
    }

    @Override
    protected void setEffect() {
        this.isThroughable();
        this.isUseable();
    }
    
}
