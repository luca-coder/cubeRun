package it.unimol.oggetti;

import it.unimol.gioco.TutorialMode;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * classe che descrive l'oggetto triangolo e ne implementa le funzionalità necessarie al movimento
 */
public class Triangolo extends Thread{
    private int x;
    private int y;
    private int larghezza;
    private int altezza;
    private int velocità = 15;
    private BufferedImage imgTriangolo;

    public Triangolo(BufferedImage image, int x, int y, int larghezza, int altezza){
        this.x = x;
        this.y = y;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.imgTriangolo = image;
    }

    public int getX() {
        return x;
    }

    @Override
    public void run(){
        while (!TutorialMode.vittoria){
            aggiorna();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void aggiorna(){
        x -= velocità;
    }

    public void disegna(Graphics g){
        g.drawImage(imgTriangolo, x, y, larghezza, altezza, null);
    }

    public Rectangle getBordi(){
        return new Rectangle(x, y, larghezza, altezza);
    }

}
