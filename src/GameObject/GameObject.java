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
    protected String name;
    /**
     * Metod untuk mengembalikan nama dari GameObject ini
     * @return nama GameObject
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Metod untuk mengembalikan URL yang diperlukan untuk merepresentasikan GameObjek ini. Sementara bersifat abstract sehingga harus di Override.
     * @return URL untuk merepresentasikan GameObjek ini.
     */
    public abstract URL sendURL();
}
