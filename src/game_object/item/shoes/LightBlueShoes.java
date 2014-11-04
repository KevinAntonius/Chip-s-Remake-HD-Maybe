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
public class LightBlueShoes extends Shoes{

    public LightBlueShoes(Chip owner){
        this.owner=owner;
    }
    
    public LightBlueShoes(int x, int y){
        this.colour="LightBlue";
        this.inStock=1;
        this.setKoordinat(x, y);
    }
    
    @Override
    public boolean usedItem() {
       if(!this.owner.getSlideable()){
            this.owner.setSlideable(false);
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
