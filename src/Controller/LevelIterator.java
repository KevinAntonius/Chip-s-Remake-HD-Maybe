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
    /**
     * Atribut untuk mengumpulkan level dalam bentuk file 
     */
    protected LinkedList<File> fileList;
	
    /**
     * Konstruktor LevelIterator yang mulai membaca folder 
     * @param folder path dari folder map
     */
    public LevelIterator(String folder)
    {
            fileList=new LinkedList<File>();
            readFolderContent(folder);
    }
	
    /**
     * Metod untuk membaca folder dan menambah folder nya untuk ditambahkan ke fileList
     * @param folder path folder level berada
     */
    protected void readFolderContent(String folder)
    {
            File folderReader=new File(folder);
            File[] folderContent=folderReader.listFiles();
            for (int i=0;i<folderContent.length;i++)
            {
                    fileList.add(folderContent[i]);
            }
    }

    /**
     * Metod untuk mendapatkan file (map) selanjutnya
     * @return Map selanjutnya
     */
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
