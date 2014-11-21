
import Controller.*;
import GameObject.GameObject;
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
        Scanner sc=new Scanner(System.in);
        c.implementsMapToWorld(c.start(path));
        int direction=0;
        
        while(!c.getChip().getDead()&&!c.getGameFinish()){
            
            for(int i=0;i<12;i++){
                for(int j=0;j<12;j++){
                    if(c.getChip().getX()==i&&c.getChip().getY()==j){
                        System.out.print("@ ");
                    }
                    else{
                        GameObject go=c.getGameObjectAt(i, j);
                        if(go==null){
                            System.out.print("  ");
                        }
                        else{
                            if(go.getName().equalsIgnoreCase("wall")){
                                System.out.print("w ");
                            }
                            else if(go.getName().equalsIgnoreCase("IC")){
                                System.out.print("i ");
                            }
                            else if(go.getName().equalsIgnoreCase("Fire Floor")){
                                System.out.print("f ");
                            }
                            else if(go.getName().equalsIgnoreCase("Pool")){
                                System.out.print("p ");
                            }
                            else if(go.getName().equalsIgnoreCase("Red Shoes")){
                                System.out.print("m ");
                            }
                            else if(go.getName().equalsIgnoreCase("Blue Shoes")){
                                System.out.print("r ");
                            }
                            else if(go.getName().equalsIgnoreCase("Barrier")){
                                System.out.print("b ");
                            }
                            else if(go.getName().equalsIgnoreCase("Finish")){
                                System.out.print("s ");
                            }
                            else if(go.getName().equalsIgnoreCase("Floor")){
                                System.out.print("  ");
                            }
                        }
                   }
                }
                System.out.println("");
            }    
            direction=sc.nextInt();
            c.chipMove(direction);
        }
    }
    
    
}
