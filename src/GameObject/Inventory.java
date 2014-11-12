/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

/**
 *
 * @author STEVEN
 */
public class Inventory {
    private Shoes[] shoes;
    public Inventory(int manyShoes){
        shoes=new Shoes[manyShoes];
    }
    
    /**
     * Metod mengembalikan boolean yang menandakan bahwa di inventory ada Shoes yang diperlukan
     * @param neededShoes Shoes yang diperlukan
     * @return rue jika ada Shoes yang diperlukan, false jika sebaliknya
     */
    public boolean checkIsThere(Shoes neededShoes){
        for(int i=0;i<shoes.length;i++){
            if(shoes[i].getName().equalsIgnoreCase(neededShoes.getName())){
                return true;
            }
        }
        return false;
    }
}
