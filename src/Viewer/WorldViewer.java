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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class WorldViewer extends JPanel {

    private final static int CANVAS_WIDTH = 600;
    private final static int CANVAS_HEIGHT = 600;
    private Controller controller;
    private String[] kodeMap;
    private String[][] mapPattern;
    private Image[] img;
    private Image imgChips;
    private int posisiX;
    private int posisiY;
    private URL currentURL;

    public WorldViewer(Controller controller) throws IOException {
        this.controller = controller;
        this.currentURL = null;
        this.setImage();
        this.fillContent();
    }

    public void clear(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.clear(g);
        Image currentImg = null;
        for (int i = 0; i < this.mapPattern.length; i++) {
            for (int j = 0; j < this.mapPattern[i].length; j++) {
                int index = 0;
                while (!this.mapPattern[i][j].equals(this.kodeMap[index])) {
                    index++;
                }
                g.drawImage(img[index], j*40, i*40, this);
            }
        }
        g.drawImage(imgChips, this.posisiX * 40, this.posisiY * 40, this);
    }

    public void moved() {
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
        try {
            //coba diskusiin
            this.imgChips = ImageIO.read(this.controller.getChip().sendCurrentURL());
        } catch (IOException ex) {
            Logger.getLogger(WorldViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    public void fillContent() throws IOException {
        this.mapPattern = this.controller.getWorld().getIsiMap();
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
    }

    public void afterTaken(int x, int y) throws IOException {
        this.mapPattern[x][y]=this.controller.getKodeMapAt(x, y);
        repaint();
    }

    public void setImage() throws IOException {
        String codeTemp = this.controller.kodeTipeGameObjekDiMapSekarang();
        URL[] urlTemp = this.controller.tipeGameObjectDiMapSekarang(codeTemp);
        this.kodeMap = new String[codeTemp.length()];
        this.img=new Image[kodeMap.length];
        for (int i = 0; i < codeTemp.length(); i++) {
            this.kodeMap[i] = codeTemp.substring(i, i + 1);
            URL temp = urlTemp[i];
            this.img[i] = ImageIO.read(temp);
        }
        this.imgChips = ImageIO.read(this.controller.getChip().sendCurrentURL());
    }
}
