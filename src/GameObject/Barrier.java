/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import java.net.URL;

/**
 *
 * @author STEVEN
 */
public class Barrier extends Wall{

    /**
     * Konstruktor Barrier yang menginisiasi nama object menjadi "Barrier"
     */
    public Barrier(){
        this.name="Barrier";
    }
    
    /**
     * metod yang akan mengembalikan true jika total chip 0
     * @return rue jika total chip = 0, false jika sebaliknya
     */
    @Override
    public boolean tryOpen() {
        if(IC.totalChip==0){
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public URL sendURL(){
        return getClass().getClassLoader().getResource("Barrier.jpg");
    }
}
