/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author STEVEN
 */
public class Level implements MapIterable{
    /**
     * path folder level berada
     */
    protected String folder;
    
    /**
     * iterator map
     */
    protected MapIterator itr;

    /**
     * Konstruktor Level yang menginisiasi level dan memulai perhitungan di itr
     * @param folder path folder
     */
    public Level(String folder)
    {
            this.folder=folder;
            itr=new LevelIterator(this.folder);
    }
    
    /**
     * Metod dari interface MapIterable untuk mengembalikan iteratornya
     * @return iteratornya
     */
    @Override
    public MapIterator getIterator() {
        return itr;
    }

    /**
     * Metod dari interface MapIterable untuk mengembalikan iterator baru
     * @return iterator baru 
     */
    @Override
    public MapIterator newIterator() {
        itr=new LevelIterator(this.folder);
        return itr;
    }
    
}
