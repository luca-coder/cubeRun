package it.unimol.gioco;

import it.unimol.GestoreCaricamenti.CaricatoreImmagini;
import it.unimol.GestoreCollisioni;
import it.unimol.Grafica.Sconfitta;
import it.unimol.Grafica.Vittoria;
import it.unimol.oggetti.Quadrato;
import it.unimol.oggetti.Triangolo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe che implementa la modalità tutorial, formata da un livello precostruito
 * @author Luca
 */
public class TutorialMode extends Canvas implements KeyListener, Runnable {

    public static final int larghezza = 800;
    public static final int altezza = 720;
    private JFrame finestra;

    private BufferedImage sfondo = null;
    private BufferedImage imgQuadrato = null;
    private BufferedImage imgTriangolo = null;
    private boolean giocoAttivo = false;
    public static boolean vittoria = false;
    private ArrayList<Triangolo> listaOstacoli = new ArrayList();

    private Quadrato quadrato;

    /**
     * costruttore della classe che chiama il metodo {@code caricaRisorse()}, che carica le immagini del gioco, e il metodo {@code iniziaGioco()}, che carica la lista di ostacoli e fa partire i thread delle entità
     * @param finestra il frame della modalità tutorial
     */
    public TutorialMode(JFrame finestra) {
        this.finestra = finestra;
        caricaRisorse();
        iniziaGioco();
    }

    private void iniziaGioco() {

        quadrato = new Quadrato(imgQuadrato, 50, 400, 20, 20);
        listaOstacoli.add(new Triangolo(imgTriangolo, 1000, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1100, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1115, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1200, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1300, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1315, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1400, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1415, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1480, 350, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1520, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1535, 400, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1600, 350, 15, 20));
        listaOstacoli.add(new Triangolo(imgTriangolo, 1680, 400, 15, 20));

        quadrato.start();
        for (Triangolo triangolo : listaOstacoli) {
            triangolo.start();
        }
    }

    private void caricaRisorse() {
        CaricatoreImmagini loader = new CaricatoreImmagini();

        sfondo = loader.caricaImmagine("/it/unimol/Immagini_gioco/sfondo.png");
        imgQuadrato = loader.caricaImmagine("/it/unimol/Immagini_gioco/quadrato2.png");
        imgTriangolo = loader.caricaImmagine("/it/unimol/Immagini_gioco/triangolo.png");
    }

    private void disegna() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(sfondo, 0, 0, larghezza, altezza, this);

        quadrato.disegna(g);

        for (Triangolo triangolo : listaOstacoli) {
            triangolo.disegna(g);
        }

        g.dispose();
        bufferStrategy.show();
    }

    private void gameOver(boolean stato) {
        if (stato) {
            new Vittoria(0);
        } else {
            new Sconfitta();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_UP)
            quadrato.salta();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void controlloVittoria(){
        int index = listaOstacoli.size();
        if (listaOstacoli.get(index - 1).getX() < quadrato.getX()){
            vittoria = true;
            this.finestra.setVisible(false);
            giocoAttivo = false;
        }
    }

    private void controlloCollisioni() {
        for (Triangolo triangolo : listaOstacoli) {
            if (GestoreCollisioni.controllaCollisione(triangolo, quadrato)) {
                this.finestra.setVisible(false);
                giocoAttivo = false;
            }
        }
    }

    /**
     * metodo che chiama il metodo {@code disegna()}, che disegna le immagini delle entità, il metodo{@code controlloVittoria()}, che controlla se il giocatore vince, e il metodo {@code controlloCollisioni()}, che controlla che il giocatore perde, finchè la variabile giocoAttivo è impostata a true. Successivamente, chiama il metodo {@code gameover()}, che , in base al valore del parametro passato, istanza la classe Vittoria o Sconfitta
     */
    @Override
    public void run() {
        giocoAttivo = true;
        while (giocoAttivo) {
            disegna();
            controlloVittoria();
            controlloCollisioni();
        }
        if (vittoria){
            gameOver(true);
        }else{
            gameOver(false);
        }
    }
}
