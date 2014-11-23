/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GameObject.*;
import Viewer.WorldViewer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author STEVEN
 */
public class Controller implements KeyListener{
    /**
     * Chip yang menjadi pemain utama dalam permainan ini dan dikontrol oleh user.
     */
    private Chip chip;
    
    /**
     * Dunia yang Chip sekarang berada. 
     */
    private World world; 
    
    
    /**
     * Kumpulan Map untuk diimplementasikan ke World
     */
    private MapIterable maps;
    
    /**
     * Atribut untuk menandakan bahwa tidak ada map lagi yang tersedia
     */
    private boolean gameFinish;
    
    /**
     * Atribut untuk menandakan bahwa level di map sekarang sudah selesai
     */
    private boolean finishLevel;
    
    /**
     * Path untuk mengakses ke map
     */
    private String path;
    
    /**
     * Viewer interface untuk dunia dan chip sehingga user dapat melihat apa yang terjadi di world dan chip
     */
    private WorldViewer worldViewer;
    
    /**
     * Isi map yang sudah diimplementasikan ke world dalam bentuk kode
     */
    private String isiMap;
    
    /**
     * limit step yang bisa dilakukan oleh user.
     */
    private int step;
    /**
     * Metod untuk menyuruh chip untuk bergerak. Chip tidak bisa bergerak ke arah 
     * tersebut jika ada tembok atau barrier. Barrier akan hancur jika semua IC 
     * sudah terkumpul dan chip bergerak ke arah barrier. Lalu di metod ini juga
     * menangani jika chip bergerak ke arah trap ,seperti FireFloor atau Pool, 
     * menangani pengambilan item IC dan juga Shoes, seperti RedShoes atau BlueShoes.
     * Menangani juga jika chip berada di Finish.
     * @param direction angka untuk Chip bergerak.
     * <ul>
     *      <li>2 untuk bergerak ke bawah</li>
     *       <li>8 untuk bergerak ke atas</li>
     *       <li>4 untuk bergerak ke kiri</li>
     *       <li>6 untuk bergerak ke kanan</li>
     * </ul>
     * @throws IOException 
     */
    public void chipMove(int direction) throws IOException{
        int x=chip.getX();
        int y=chip.getY();
        if(direction == 8){
            x-=1; 
        }else if(direction == 4){
            y-=1;
        }else if(direction == 6){
            y+=1;
        }else if(direction == 2){
            x+=1;
        }
        if(!this.wallCheck(x,y)){
            GameObject go=this.world.getObjectAt(x, y);
            if((this.world.getKodeMapAt(this.chip.getX(), this.chip.getY()).equalsIgnoreCase("f")||this.world.getKodeMapAt(this.chip.getX(), this.chip.getY()).equalsIgnoreCase("p"))&&(this.world.getKodeMapAt(x, y).equalsIgnoreCase("n")||this.world.getKodeMapAt(x, y).equalsIgnoreCase("i")||this.world.getKodeMapAt(x, y).equalsIgnoreCase("m")||this.world.getKodeMapAt(x, y).equalsIgnoreCase("r"))){
                this.chip.setToNormalWalker();
            }
           if(this.deathCheck(direction)){
           }
            if(direction == 2){
                chip.moveDown();
            }else if(direction == 4){
                chip.moveLeft();
            }else if(direction == 6){
                chip.moveRight();
            }else if(direction == 8){
                chip.moveUp();
            }
            this.step--;
            this.setTrapVisible();
           this.itemCheck();
           
           if(this.finishCheck()){
               this.finishLevel=true;
           }
       }
       else{
           if(this.tryOpenWallOrBarrier(x, y)){
               this.world.destroyObjectAt(x, y);
               this.worldViewer.afterTaken(x,y);
               
           }
       }
    }
    
    /**
     * Metod untuk mengetahui apakah di x dan y ada objek bernama Wall atau Barrier
     * @param x baris
     * @param y kolom
     * @return benar jika di baris x dan y ada Wall atau Barrier.
     */
    private boolean wallCheck(int x, int y){
        if(world.getObjectAt(x,y)==null){
            return false;
        }
        return (world.getObjectAt(x,y).getName().equalsIgnoreCase("Wall")||world.getObjectAt(x, y).getName().equalsIgnoreCase("Barrier"));
    }
    
    /**
     * Metod untuk mengeluarkan trap yang tidak terlihat di posisi chip berada
     * @param x
     * @param y 
     */
    private void setTrapVisible(){
        int x=this.chip.getX();
        int y= this.chip.getY();
        GameObject go1=world.getObjectAt(x-1, y);
        GameObject go2=world.getObjectAt(x, y-1);
        GameObject go3=world.getObjectAt(x+1, y);
        GameObject go4=world.getObjectAt(x, y+1);
        if(go1.getName().equalsIgnoreCase("IPool")){
            world.setGameObjectAt(x-1, y, new Pool(), "p");
        }
        else if(go1.getName().equalsIgnoreCase("IFire Floor")){
            world.setGameObjectAt(x-1, y, new Pool(), "p");
        }
        if(go2.getName().equalsIgnoreCase("IPool")){
            world.setGameObjectAt(x, y-1, new Pool(), "p");
        }
        else if(go2.getName().equalsIgnoreCase("IFire Floor")){
            world.setGameObjectAt(x, y-1, new Pool(), "p");
        }
        if(go3.getName().equalsIgnoreCase("IPool")){
            world.setGameObjectAt(x+1, y, new Pool(), "p");
        }
        else if(go3.getName().equalsIgnoreCase("IFire Floor")){
            world.setGameObjectAt(x+1, y, new Pool(), "p");
        }
        if(go4.getName().equalsIgnoreCase("IPool")){
            world.setGameObjectAt(x, y+1, new Pool(), "p");
        }
        else if(go4.getName().equalsIgnoreCase("IFire Floor")){
            world.setGameObjectAt(x, y+1, new Pool(), "p");
        }
    }
    
    /**
     * Metod untuk mengecek apakah chip meninggal atau tidak. jika Chip berada di trap FireFloor atau pool tanpa memiliki sepatu yang diperlukan, maka Chip di set meninggal. Tidak jika sebaliknya.
     * @return true jika chip meninggal. Tidak jika chip memang tidak meninggal atau letak chip sekarang bukan trap.
     */
    private boolean deathCheck(int direction){
        int x=0;
        int y=0;
        if(direction ==2){
            x++;
        }
        else if(direction ==4){
            y--;
        }
        else if(direction ==6){
            y++;
        }
        else if(direction ==8){
            x--;
        }
        GameObject go =  world.getObjectAt(chip.getX()+x, chip.getY()+y);
        boolean isDead=false;
        if(go!=null){
             if(go.getName().equalsIgnoreCase("Fire Floor")||go.getName().equalsIgnoreCase("Pool")||go.getName().equalsIgnoreCase("HCable")||go.getName().equalsIgnoreCase("VCable")||go.getName().equalsIgnoreCase("IFire Floor")||go.getName().equalsIgnoreCase("IPool")){
                Traps trap=(Traps) go;
                if(!chip.shoesCheck(trap.getRequirementShoes())){
                chip.isDead();
                }
                else{
                    if(go.getName().equalsIgnoreCase("Fire Floor")||go.getName().equalsIgnoreCase("IFire Floor")){
                        this.chip.setToLavaWalker();
                    }
                    else if(go.getName().equalsIgnoreCase("Pool")||go.getName().equalsIgnoreCase("IPool")){
                        this.chip.setToWaterWalker();
                    }
                }
                isDead= chip.getDead();
            }         
        }
        
            return isDead;
    }
    
    /**
     * Metod untuk mengecek objek yang sekarang Chip tempati merupakan objek yang
     * bernama Blue Shoes, Red Shoes, atau IC. Jika iya, maka objek tsb akan diambil 
     * oleh chip dan lalu menghancurkan objek tsb di world.
     * @throws IOException 
     */
    private void itemCheck() throws IOException{
        GameObject go = world.getObjectAt(chip.getX(),chip.getY());
        if(go!=null){
            if(go.getName().equalsIgnoreCase("Blue Shoes")){
                this.chip.getShoes((Shoes)go);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.worldViewer.afterTaken(chip.getX(),chip.getY());
            }else if(go.getName().equalsIgnoreCase("Red Shoes")){
                this.chip.getShoes((Shoes)go);
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.worldViewer.afterTaken(chip.getX(),chip.getY());
            }else if(go.getName().equalsIgnoreCase("IC")){
                IC ic=(IC)go;
                ic.getIC();
                this.world.destroyObjectAt(chip.getX(),chip.getY());
                this.worldViewer.afterTaken(chip.getX(),chip.getY());
            }
        }   
    }
    
    /**
     * Metod untuk mengecek apakah objek ditempati chip bernama Finish
     * @return true jika objek objek yang ditempati chip bernama Finish, false jika sebaliknya
     */
    private boolean finishCheck(){
        GameObject go = world.getObjectAt(chip.getX(),chip.getY());
        if(go!=null){
            if(go.getName().equalsIgnoreCase("Finish")){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metod untuk membuka wall atau barrier di baris x dan y
     * @param x baris
     * @param y kolom
     * @return true jika barrier dan semua IC terkumpul, false jika wall atau barrier dan semua IC tidak terkumpul.
     */
    private boolean tryOpenWallOrBarrier(int x, int y){
        Wall barrier = (Wall) world.getObjectAt(x,y);
        return barrier.tryOpen();
    }
    
    /**
     * Metod untuk menginisialisasi kumpulan map melalui parameter path dan lalu memulai game dengan map pertama
     * @param path 
     * @return Map level perama
     */
    public Map start(String path){
        this.path=path;
        maps=new Level(path);
        MapIterator mapi=maps.getIterator();
        return (Map)mapi.next();
    }
    
    /**
     * Metod untuk melanjutkan map dengan level selanjutnya
     * @return map dengan leve selanjutnya
     */
    private Map nextLevel(){
        this.step=150;
        return (Map)this.maps.getIterator().next();
    }
    
   /**
    * Metod untuk mengimplementasikan kode di map menjadi ke World
    * @param newMap kode map
    */
   public void implementsMapToWorld(Map newMap){
       this.finishLevel=false;
       String str=newMap.getIsiMap();
       this.isiMap=str.substring(6);
       String []split=str.split("\n");
       this.world=new World((Integer.parseInt(split[0])),(Integer.parseInt(split[1])));
       for(int i=0;i<this.world.getKolom();i++){
           for(int j=0;j<this.world.getBaris();j++){
               GameObject go=null;
               String tempObject="";
               if(j==this.world.getBaris()-1){
                   tempObject=split[2+i].substring(j);
               }
               else{
                    tempObject=split[2+i].substring(j, j+1);
               }
               if(tempObject.equalsIgnoreCase("w")){
                   go=new NormalWall();
               }
               else if(tempObject.equalsIgnoreCase("i")){
                   go=new IC();
               }
               else if(tempObject.equalsIgnoreCase("f")){
                   go=new FireFloor();
               }
               else if(tempObject.equalsIgnoreCase("p")){
                   go=new Pool();
               }
               else if(tempObject.equalsIgnoreCase("m")){
                   go=new RedShoes();
               }
               else if(tempObject.equalsIgnoreCase("r")){
                   go=new BlueShoes();
               }
               else if(tempObject.equalsIgnoreCase("b")){
                   go=new Barrier();
               }
               else if(tempObject.equalsIgnoreCase("s")){
                   go=new Finish();
               }
               else if(tempObject.equalsIgnoreCase("c")){
                   go=new Floor();
                   this.chip=new Chip(i,j);
               }
               else if(tempObject.equalsIgnoreCase("n")){
                   go=new Floor();
               }
               else if(tempObject.equalsIgnoreCase("l")){
                   go=new InvisibleFireFloor();
               }
               else if(tempObject.equalsIgnoreCase("o")){
                   go=new InvisiblePoolTrap();
               }
               else if(tempObject.equalsIgnoreCase("v")){
                   go=new InvisibleWall();
               }
               else if(tempObject.equalsIgnoreCase("k")){
                   go=new VerticalCable();
               }
               else if(tempObject.equalsIgnoreCase("a")){
                   go=new HorizontalCable();
               }
               if(tempObject.equalsIgnoreCase("c")){
                   tempObject="n";
               }
               this.world.setGameObjectAt(i, j, go,tempObject);
               
           }
       }
   }
   
   
   /**
    * Metod untuk mendapatkan Chip yang sekarang di kontrol oleh user
    * @return chip Chip yang sekarang di kontrol oleh user
    */
   public Chip getChip(){
       return this.chip;
   }
   
   /**
    * Metod untuk mendapatkan Chip
    * @return 
    */
   public URL sendURLChip(){
       return this.chip.sendCurrentURL();
   }
    
    
    /**
     * Metod untuk mendapatkan URL pada GameObject di baris-x dan kolom-y
     * @param x baris
     * @param y kolom
     * @return URL pada GameObject di baris-x dan kolom-y
     */
    public URL sendURLAtObject(int x, int y){
        return this.world.sendURLAtObject(x, y);
    }
    
    /**
     * Metod untuk mengembalikan atribut gameFinish
     * @return 
     */
    public boolean getGameFinish(){
        return this.gameFinish;
    }

    /**
     * Metod untuk mengembalikan atribu world
     * @return 
     */
    public World getWorld(){
        return this.world;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Metod yang meng-override keyPressed.
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(!this.chip.getDead()&&!this.finishLevel){
            int direction = -1;
            if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W){
                direction = 8;
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A){
                direction = 4;
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D){
                direction = 6;
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S){
                direction = 2;
            }
            try {
                this.chipMove(direction);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            this.worldViewer.moved();
        }
        else if(this.finishLevel){
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                Map newMap=this.nextLevel();
               if(newMap==null){
                   this.gameFinish=true;
               }
               else{
                  this.implementsMapToWorld(newMap);
                    try {
                        this.worldViewer.fillContent();
                        this.worldViewer.setImage();
                    this.worldViewer.repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                  this.worldViewer.moved();
               }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
                this.implementsMapToWorld(this.restart());
            try {
                this.worldViewer.fillContent();
                this.worldViewer.repaint();
                this.worldViewer.setImage();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            }
        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    /**
     * Metod untuk merestart map. Metod ini juga mengembalikan banyak IC menjadi 0.
     * @return Map lvl pertama
     */
    public Map restart(){
        this.step=150;
        IC ic=new IC();
        while(IC.totalChip!=0){
            ic.getIC();
        }
        maps=new Level(path);
        MapIterator mapi=maps.newIterator();
        
        return (Map)mapi.next();
    }
    
    /**
     * Metod untuk mengeset worldViewer menjadi worldV
     * @param worldV WorldViewer GUI yang sekarang muncul
     */
    public void implementsWorldViewer(WorldViewer worldV){
        this.worldViewer = worldV;
    }
    
    /**
     * Metod untuk mengembalikan kumpulan string yang berisi kode dari tiap GameObjeck yang berbeda kelas
     * @return kumpulan string yang berisi kode dari tiap GameObjeck yang berbeda kelas
     */
    public String kodeTipeGameObjekDiMapSekarang(){
        String str="";
        String[][] arrayMap=this.world.getIsiMap();
        for(int i=0;i<arrayMap.length;i++){
            for(int j=0;j<arrayMap[i].length;j++){
                if(str.equalsIgnoreCase("")){
                    str+=""+arrayMap[i][j];
                }
                else{
                    if(!this.checkExistChar(str, arrayMap[i][j])){
                        if(!arrayMap[i][j].equalsIgnoreCase("c")){
                            if(arrayMap[i][j].equalsIgnoreCase("l")){
                                str=str+"lf";
                            }
                            else if(arrayMap[i][j].equalsIgnoreCase("o")){
                                str=str+"op";
                            }
                            else{
                                str=str+arrayMap[i][j];
                            }
                        }
                    }
                }
            }
        }
        return str;
    }
    
    /**
     * metod untuk mengecheck apakah kode di newString ada di kumpulan String str
     * @param str kumpulan String
     * @param newString kode GameObject
     * @return true jika ada, false jika tidak ada
     */
    private boolean checkExistChar(String str, String newString){
        boolean exist=false;
        for(int i=0;i<str.length()&&!exist;i++){
            if(str.substring(i, i+1).equalsIgnoreCase(newString)){
                exist=true;
            }
        }
        return exist;
    }
    
    /**
     * Metod untuk memberi tahu dalam array URL dari String parameter banyak kode tipe 
     * @param kodeTipeGameObject atribut atau metod yang memanggil kodeTipeGameObjekDiMapSekarang()
     * @return array URL untuk image yang sesuai dengan kodeTipeGamebject
     */
    public URL[] tipeGameObjectDiMapSekarang(String kodeTipeGameObject){
        String str=kodeTipeGameObject;
        GameObject[] gos=new GameObject[str.length()];
        GameObject temp;
        String tempKode;
        for(int i=0;i<gos.length;i++){
            tempKode=str.substring(i, i+1);
            if(tempKode.equalsIgnoreCase("w")){
                temp=new NormalWall();
            }
            else if(tempKode.equalsIgnoreCase("m")){
                temp=new RedShoes();
            }
            else if(tempKode.equalsIgnoreCase("f")){
                temp=new FireFloor();
            }
            else if(tempKode.equalsIgnoreCase("i")){
                temp=new IC();
                IC ic=(IC)temp;
                ic.getIC();
            }
            else if(tempKode.equalsIgnoreCase("p")){
                temp=new Pool();
            }
            else if(tempKode.equalsIgnoreCase("b")){
                temp=new Barrier();
            }
            else if(tempKode.equalsIgnoreCase("r")){
                temp=new BlueShoes();
            }
            else if(tempKode.equalsIgnoreCase("s")){
                temp=new Finish();
            }
               else if(tempKode.equalsIgnoreCase("o")){
                   temp=new InvisiblePoolTrap();
               }
               else if(tempKode.equalsIgnoreCase("v")){
                   temp=new InvisibleWall();
               }
               else if(tempKode.equalsIgnoreCase("k")){
                   temp=new VerticalCable();
               }
               else if(tempKode.equalsIgnoreCase("a")){
                   temp=new HorizontalCable();
               }
            else {
                temp=new Floor();
            }
            gos[i]=temp;
        }
        URL []result=new URL[gos.length];
        for(int i=0;i<result.length;i++){
            result[i]=gos[i].sendURL();
        }
        return result;
    }
    
    /**
     * Metod untuk memanggil metod di world bernama getKodeMapAt(int x, int y)
     * @param x baris
     * @param y kolom
     * @return kode map dari baris x dan kolom y
     */
    public String getKodeMapAt(int x, int y){
        return this.world.getKodeMapAt(x, y);
        
    }
}
