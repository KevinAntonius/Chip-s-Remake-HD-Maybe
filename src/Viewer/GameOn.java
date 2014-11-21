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
        ChipsViewer chip = new ChipsViewer(controller);
        WorldViewer world = new WorldViewer(controller);
        f.getContentPane().add("Center",world);
        f.getContentPane().add("Center",chip);
        f.pack();
        f.setSize(480,480);
        f.setLocation(0, 0);
        f.setVisible(true);
    }
}
