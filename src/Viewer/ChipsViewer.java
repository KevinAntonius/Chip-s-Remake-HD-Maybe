/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.Controller;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class ChipsViewer extends JPanel{
    
    private static final int CANVAS_WIDTH = 40;
    private static final int CANVAS_HEIGHT = 40;
    
    private int posisiX;
    private int posisiY;
    
    private Controller controller;
    
    private Image img;
    
    public ChipsViewer(Controller controller){
        this.controller = controller;
        this.posisiX = this.controller.getChip().getX();
        this.posisiY = this.controller.getChip().getY();
        try {
            this.img = ImageIO.read(this.controller.getChip().sendDownStandURL());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, this.posisiX*40, this.posisiY*40, null);
    }
    
    public void moved(){
        this.posisiX = this.controller.getChip().getX();
        this.posisiY = this.controller.getChip().getY();
        repaint();
    }
}
