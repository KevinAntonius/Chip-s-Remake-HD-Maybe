/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.item.key;

import game_object.chip.Chip;

/**
 *
 * @author STEVEN
 */
public class LightBlueKey extends Key{
    
    public LightBlueKey(Chip owner){
        this.owner=owner;
    }
    
    public LightBlueKey(int x, int y){
        this.colour="LightBlue";
        this.setKoordinat(x,y);
        this.setEffect();
    }
    
    @Override
    public boolean usedItem() {
        if(this.getInStock()!=0){
            this.inStock--;
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
