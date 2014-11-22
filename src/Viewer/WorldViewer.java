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
    private Image imgChips;
    private int posisiX;
    private int posisiY;
    private URL currentURL;
    
    public WorldViewer(Controller controller) throws IOException{
        this.controller =controller;
        this.currentURL = null;
        this.fillContent();
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
        g.drawImage(imgChips, this.posisiX*40, this.posisiY*40, this);
    }
    
    public void moved(){
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
        repaint();
    }
    
    public void fillContent() throws IOException{
        Object nullExam = null;
        this.img = new Image[this.controller.getWorld().getKolom()][this.controller.getWorld().getBaris()];
        for(int i = 0;i<this.controller.getWorld().getKolom();i++){
            for(int j = 0;j<this.controller.getWorld().getBaris();j++){
                nullExam = this.controller.getGameObjectAt(i, j);
                if(nullExam!=null){
                    this.currentURL = this.controller.sendURLAtObject(i, j);
                    this.img[j][i] = ImageIO.read(currentURL);
                }
            }
        }
        this.imgChips = ImageIO.read(this.controller.getChip().sendDownStandURL());
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
    }
    
    public void afterTaken(int x, int y) throws IOException{
        this.img[y][x] = ImageIO.read(this.controller.getGameObjectAt(x, y).sendURL());
        repaint();
    }
}
