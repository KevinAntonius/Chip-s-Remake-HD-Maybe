package GameObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STEVEN
 */
public abstract class GameObject {
    String path;
    String name;
    public String getPath(){
        return this.name;
    }
    
    public void setPath(String newPath){
        this.path=newPath;
    }
    
    public String getName(){
        return this.name;
    }
}
