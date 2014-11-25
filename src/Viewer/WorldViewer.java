/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controller.Controller;
import GameObject.IC;
import java.awt.Font;
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
    private Image tutorial;
    private int posisiX;
    private int posisiY;

    /**
     * Konstruktor WorldViewer untuk menginisiasi controller
     * @param controller
     * @throws IOException 
     */
    public WorldViewer(Controller controller) throws IOException {
        this.controller = controller;
        this.setImage();
        this.fillContent();
        
    }

    /**
     * Method override dari JPanel untuk menggambar komponen
     * @param g object Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Alien Encounters", Font.BOLD, 20));
        if(this.controller.getStartSignal()){
            g.drawImage(tutorial,0,0,null);
        }
        else if(this.controller.getGameFinish()){
            g.drawString("YOU HAVE BEAT THE GAME", 100, 200);
            g.drawString(String.format("Score : %d", this.controller.getStep()),180,240);
        }
        else if(this.controller.getChip().getDead()){
            g.drawString("YOU LOSE", 200, 200);
        }
        else{
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
            g.setFont(new Font("Alien Encounters", Font.BOLD, 20));
            g.drawString(String.format("IC yang tersisa : %d", IC.totalChip), 230, 503);
            g.drawString(String.format("Score : %d", this.controller.getStep()),80,503);
        }
    }

    /**
     * Method untuk menggambarkan hasil perpindahan tempat Chip
     */
    public void moved() {
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
        try {
           this.imgChips = ImageIO.read(this.controller.getChip().sendCurrentURL());
        } catch (IOException ex) {
            Logger.getLogger(WorldViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    /**
     * Method untuk menginisiasi mapPattern dan lokasi Chip berdasarkan koordinat x,y
     * @throws IOException 
     */
    public void fillContent() throws IOException {
        this.mapPattern = this.controller.getWorld().getIsiMap();
        this.posisiY = this.controller.getChip().getX();
        this.posisiX = this.controller.getChip().getY();
    }

    /**
     * Method untuk menggambarkan perubahan setelah Chip mengambil object seperti IC dan sepatu
     * @param x lokasi object berdasarkan koordinat X
     * @param y lokasi object berdasarkan koordinat Y
     * @throws IOException 
     */
    public void afterTaken(int x, int y) throws IOException {
        this.mapPattern[x][y]=this.controller.getKodeMapAt(x, y);
        repaint();
    }

    /**
     * Method untuk menginisialisasikan gambar - gambar yang akan digunakan
     * @throws IOException 
     */
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
        this.tutorial = ImageIO.read(getClass().getClassLoader().getResource("chipTutorial.jpg"));
    }
}
