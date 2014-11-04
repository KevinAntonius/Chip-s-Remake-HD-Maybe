/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_object.chip;

import game_object.*;
import game_object.item.IC;
import game_object.item.Item;
import game_object.item.key.*;
import game_object.item.shoes.*;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author STEVEN
 */
public class Chip extends GameObject implements Destroyable, Moveable,Sinkable,Burnable,Slideable{
    public int score=0; 
    private int step=0;
    private Item[] item={new BlueKey(this),new LightBlueKey(this),new GreenKey(this),new RedKey(this),new BlueShoes(this),new LightBlueShoes(this),new GreenShoes(this),new RedShoes(this),};
    private IC ic=new IC(this);
    
    public Chip(Image sprite,int x, int y){
        this.sprite=sprite;
        this.koordinat=new Point(x,y);
        this.setEffect();
    }
    public boolean move(int direction){
        boolean canMove=false;
        Point temp=new Point(this.koordinat.x,this.koordinat.y);
        if(direction==2){
            this.koordinat.x++;
        }
        else if(direction==4){
            this.koordinat.y--;
        }
        else if(direction==6){
            this.koordinat.x--;
        }
        else if(direction==8){
            this.koordinat.y++;
        }
        GameObject go=this.floor.getAboveFloor(this);
        if(!go.getThroughable()){
            this.koordinat=temp;
        }
        else{
            canMove=true;
        }
        return canMove;
    }    

    @Override
    public void setEffect() {
        this.isBurnable();
        this.isDestroyable();
        this.isMoveable();
        this.isSinkable();
        this.isSlideable();
   }
    
   public void setBurnable(boolean able){
       this.canBeBurnt=able;
   }
    
   public void setSinkable(boolean able){
       this.canBeSink=able;
   }
    
   public void setMoveable(boolean able){
       this.canBeMove=able;
   }
   
   public void setSlideable(boolean able){
       this.canBeSlide=able;
   }

    @Override
    public void isDestroyable() {
      this.canBeDestroy=true;
    }

    @Override
    public void isMoveable() {
        this.canBeMove=true;
    }

    @Override
    public void isBurnable() {
        this.canBeBurnt=true;
    }

    @Override
    public void isSinkable() {
        this.canBeSink=true;
    }

    @Override
    public void isSlideable() {
        this.canBeSlide=true;
    }
}
