/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.Controller;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Kevin
 */
public class GameOn {
    public static void main(String[] args) throws IOException{
        JFrame f = new JFrame("Chip's Challenge");
        Controller controller = new Controller();
        controller.implementsMapToWorld(controller.start("MapLevel"));
        //controller.implementChip();
        WorldViewer world = new WorldViewer(controller);
        f.getContentPane().add("Center",world);
<<<<<<< HEAD
        f.addKeyListener(controller);
=======
        //f.getContentPane().add("Center",chip);
>>>>>>> origin/master
        f.setSize(480,480);
        f.setLocation(0, 0);
        f.setVisible(true);
    }
}
