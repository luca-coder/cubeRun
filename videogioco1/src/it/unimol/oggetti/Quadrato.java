package it.unimol.oggetti;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * classe che descrive l'oggetto quadrato e ne implementa le funzionalità necessarie al movimento
 */
public class Quadrato extends Thread{
    private int x;
    private int y;
    private int larghezza;
    private int altezza;
    private BufferedImage imgQuadrato;

    public Quadrato(BufferedImage image, int x, int y, int larghezza, int altezza){
        this.x = x;
        this.y = y;
        this. altezza = altezza;
        this.larghezza = larghezza;
        this.imgQuadrato = image;
    }

    public void disegna(Graphics g){
        g.drawImage(imgQuadrato, x, y, larghezza, altezza, null);
    }

    public int getX() {
        return x;
    }

    public void salta(){
        for (int i = 0; i<5; i++){
            y-=12;
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j<5; j++){
            y+=12;
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Rectangle getBordi(){
        return new Rectangle(x, y, larghezza, altezza);
    }

}
