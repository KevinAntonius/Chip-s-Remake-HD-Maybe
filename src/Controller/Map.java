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
    /**
     * Path file 
     */
    protected String  fileName;
    
    /**
     * File map dari path 
     */
    protected File mapTxt;
    
    /**
     * Isi map dari file
     */
    protected String isiMap="";
    
    /**
     * Konstruktor map yang langsung memasukan isi map dan file nya
     * @param mapTxt File
     */
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
    
    /**
     * Metod untuk mendapatkan nama file
     * @return 
     */
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
         * n-floor
         * o-invisiblePoolTrap
         * l-invisibleFireFloor
         * v-invisibleWall
         * a-verticalCable
         * k-horizontalCable
         * -End-
         * @return angka atau kata
         * @throws FileNotFoundException 
         */
        public String getIsiMap() {
            return this.isiMap;
        }
}
