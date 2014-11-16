/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author STEVEN
 */
public class Map {
    protected String  fileName;
    protected File mapTxt;
    protected String isiMap="";
    public Map(File mapTxt)
	{
            this.mapTxt=mapTxt;
		this.fileName=null;
		try
		{
			Scanner sc = new Scanner(mapTxt);
			this.fileName=mapTxt.getCanonicalPath();
                        String temp=sc.next();
                        if(temp.equalsIgnoreCase("-Start-")){
                            temp=sc.next();
                            do{
                                this.isiMap+=temp+"\n";
                                temp=sc.next();
                            }while(!temp.equalsIgnoreCase("-End-"));
                        }
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public String getFilename()
	{
		return this.getFilename();
	}
        
        /**
         * -Start- -> berarti mulai dari sini
         * angka pertama adalah x
         * angka kedua adalah y
         * w-wall
         * i-IC
         * f-fireFloor
         * p-Pool
         * m-redShoes
         * r-blueShoes
         * b-barrier
         * s-finish
         * c-chip
         * n-null/normal floor
         * -End-
         * @return angka atau kata
         * @throws FileNotFoundException 
         */
        public String getIsiMap() {
            return this.isiMap;
        }
}
