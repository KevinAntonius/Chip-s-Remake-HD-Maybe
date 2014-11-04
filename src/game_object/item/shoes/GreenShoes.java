/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.item.shoes;

import game_object.chip.Chip;

/**
 *
 * @author STEVEN
 */
public class GreenShoes extends Shoes{

    public GreenShoes(Chip owner){
        this.owner=owner;
    }
    
    public GreenShoes(int x, int y){
        this.colour="Green";
        this.inStock=1;
        this.setKoordinat(x, y);
    }
    
    @Override
    public boolean usedItem() {
       if(!this.owner.getMoveable()){
            this.owner.setMoveable(false);
            return true;
        }
        else{
            return false;
        }
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
