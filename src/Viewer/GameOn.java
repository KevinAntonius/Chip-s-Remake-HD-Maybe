/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.Controller;
import java.awt.Dimension;
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
        controller.implementsMapToWorld(controller.start("src\\MapLevel"));
        WorldViewer world = new WorldViewer(controller);
        controller.implementsWorldViewer(world);
        f.getContentPane().add("Center",world);
        f.pack();
        f.addKeyListener(controller);
        f.setSize(new Dimension(485,543));
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
