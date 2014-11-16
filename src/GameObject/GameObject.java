package GameObject;

import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STEVEN
 */
public abstract class GameObject {
    protected String path;
    protected String name;
    protected URL url;
    public String getPath(){
        return this.name;
    }
    
    public void setPath(String newPath){
        this.path=newPath;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setURL(String newURL){
        this.url=getClass().getClassLoader().getResource(newURL);
    }
    
    public URL sendURL(){
        return this.url;
    }
}
