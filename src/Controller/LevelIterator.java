/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author STEVEN
 */
public class LevelIterator implements MapIterator{
    protected Stack<File> fileStack;
	
	public LevelIterator(String folder)
	{
		fileStack=new Stack<File>();
		readFolderContent(folder);
	}
	
	protected void readFolderContent(String folder)
	{
		File folderReader=new File(folder);
		File[] folderContent=folderReader.listFiles();
		for (int i=0;i<folderContent.length;i++)
		{
			fileStack.add(folderContent[i]);
		}
	}

    @Override
    public Object next() {
		if (fileStack.isEmpty())
		{
			return null;
		}
		else
		{
			do
			{
				File currentFile=fileStack.pop();
				if (currentFile.isDirectory())
				{
					try
					{
						readFolderContent(currentFile.getCanonicalPath());
					}
					catch (IOException e)
					{
						e.printStackTrace();
						return null;
					}
				}
				else
				{
					return new Map(currentFile);
				}
				
			} while (!fileStack.isEmpty());
			return null;
		}			
	}

}
