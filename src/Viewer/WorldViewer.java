/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.Controller;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class WorldViewer extends JPanel{
    
    private final static int CANVAS_WIDTH = 600;
    private final static int CANVAS_HEIGHT = 600;
    
    private Controller controller;
    private Image[][] img;
    private URL currentURL;
    
    public WorldViewer(Controller controller) throws IOException{
        this.controller =controller;
        this.currentURL = null;
        this.img = new Image[this.controller.getWorld().getKolom()][this.controller.getWorld().getBaris()];
        for(int i = 0;i<this.controller.getWorld().getBaris();i++){
            for(int j = 0;j<this.controller.getWorld().getKolom();j++){
                if(this.controller.getGameObjectAt(j, j)!=null){
                    this.currentURL = this.controller.sendURLAtObject(j, j);
                    this.img[i][j] = ImageIO.read(currentURL);
                }
            }
        }
    }
    
    public void clear(Graphics g){
        super.paintComponent(g);
    }
    
    @Override
    public void paintComponent(Graphics g){
        this.clear(g);
        Image currentImg = null;
        for(int i = 0;i<this.img.length;i++){
            for(int j = 0;j<this.img[i].length;j++){
                currentImg = this.img[i][j];
                if(currentImg != null){
                    g.drawImage(currentImg, i*40, j*40, null);
                }
            }
        }
    }
}
