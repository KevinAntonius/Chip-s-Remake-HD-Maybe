
import Controller.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STEVEN
 */
public class TextTester {
    public static void main(String[] args) {
        String path="MapLevel";
//        MapIterable itr=new Level(path);
//        MapIterator mi=itr.getIterator();
//        Map map=null;
//        while((map=(Map)mi.next())!=null){ 
//            String str=map.getIsiMap();
//            str=map.getIsiMap();
//            System.out.println(str);
//            str=map.getIsiMap();
//         }    
        Controller c=new Controller();
        
        c.implementsMapToWorld(c.start(path));
    }
}
