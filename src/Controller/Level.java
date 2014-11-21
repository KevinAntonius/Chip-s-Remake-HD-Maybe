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
    protected String folder;
    protected MapIterator itr;
	
	public Level(String folder)
	{
		this.folder=folder;
                itr=new LevelIterator(this.folder);
	}
    @Override
    public MapIterator getIterator() {
        return itr;
    }

    @Override
    public MapIterator newIterator() {
        itr=new LevelIterator(this.folder);
        return itr;
    }
    
}
