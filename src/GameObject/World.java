/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class World {
    private GameObject[][] object;
    
    
    public World(int x, int y){
        this.object=new GameObject[x][y];
    }
    
    public GameObject getObjectAt(int x,int y){
        return this.object[x][y];
    }
}
