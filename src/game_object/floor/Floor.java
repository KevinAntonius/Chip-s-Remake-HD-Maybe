package game_object.floor;

import game_object.GameObject;
import game_object.chip.Chip;
import java.awt.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author STEVEN
 */
public class Floor {
    public GameObject[][] aboveFloor;
    public Image sprite;
    
    public Floor(int n){
        this.aboveFloor=new GameObject[n][n];
    }
    
    public void setObjectAboveFloor(GameObject go){
        aboveFloor[go.koordinat.x][go.koordinat.y]=go;
    }
    
    public GameObject getAboveFloor(GameObject go){
        return this.aboveFloor[go.koordinat.x][go.koordinat.y];
    }
}
