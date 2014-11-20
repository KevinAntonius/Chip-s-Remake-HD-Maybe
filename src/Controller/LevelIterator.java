/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author STEVEN
 */
public class LevelIterator implements MapIterator{
    protected LinkedList<File> fileList;
	
	public LevelIterator(String folder)
	{
		fileList=new LinkedList<File>();
		readFolderContent(folder);
	}
	
	protected void readFolderContent(String folder)
	{
		File folderReader=new File(folder);
		File[] folderContent=folderReader.listFiles();
		for (int i=0;i<folderContent.length;i++)
		{
			fileList.add(folderContent[i]);
		}
	}

    @Override
    public Object next() {
		if (fileList.isEmpty())
		{
			return null;
		}
		else
		{
			do
			{
				File currentFile=fileList.pop();
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
				
			} while (!fileList.isEmpty());
			return null;
		}			
	}

}
