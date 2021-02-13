package it.unimol.GestoreCaricamenti;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * classe che si occupa di caricare le immagini di tutte le entità presenti nel gioco
 * @author Luca
 */
public class CaricatoreImmagini {
    private BufferedImage image;

    /**
     *
     * @param posizione la path dell' immagine da caricare
     * @return un bufferedImage che descrive l'immagine da visualizzare con un buffer
     *
     */
    public BufferedImage caricaImmagine(String posizione){
        try {
            image = ImageIO.read(getClass().getResource(posizione));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
