package game_object;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import game_object.floor.Floor;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author STEVEN
 */
public abstract class GameObject {
    public String str="tes";
    public Image sprite=null;
    protected boolean canBeDestroy=true;
    protected boolean canBeUse;
    protected boolean canBeThrough;
    protected boolean canBeMove;
    protected boolean canBeSlide;
    protected boolean canBeSink;
    protected boolean canBeBurnt;
    public Point koordinat=new Point();
    public boolean visible=true;
    protected Floor floor;
    
    public void setSprite(Image newSprite){
        this.sprite=newSprite;
    }
    
    protected abstract void setEffect();
    
    public boolean getDestroyable(){
        return this.canBeDestroy;
    }
    
    public boolean getUseable(){
        return this.canBeUse;
    }
    
    public boolean getThroughable(){
        return this.canBeThrough;
    }
    
    public boolean getSlidable(){
        return this.canBeSlide;
    }
    
    public boolean getMoveable(){
        return this.canBeMove;
    }
    
    public boolean getSinkable(){
        return this.canBeSink;
    }
    
    public boolean getBurnable(){
        return this.canBeBurnt;
    }
    
    public boolean getSlideable(){
        return this.canBeSlide;
    }
    
    protected void setKoordinat(int x, int y){
        koordinat.x=x;
        koordinat.y=y;
    }
    
    
}
