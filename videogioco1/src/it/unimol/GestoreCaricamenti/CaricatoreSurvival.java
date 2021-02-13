package it.unimol.GestoreCaricamenti;

import it.unimol.gioco.SurvivalMode;
import it.unimol.gioco.TutorialMode;

import javax.swing.*;
import java.awt.*;

/**
 * classe che crea il frame della modalità survival e fa partire il thread nel quale viene chiamata
 */
public class CaricatoreSurvival {
    /**
     * costruttore della classe che crea un nuovo JFrame che opsiterà la modalitò survival e crea un nuovo thread nel quale verrà chiamata
     * @param finestraGioco la finestra SceltaDifficoltà che verrà settata a non visibile
     * @param difficolta la difficoltà del livello scelta dal giocatore
     */
    public CaricatoreSurvival(JFrame finestraGioco, int difficolta){
        finestraGioco.setVisible(false);

        JFrame schermataSurvival = new JFrame();

        Dimension dimesioneFinestra = new Dimension(TutorialMode.larghezza, TutorialMode.altezza);
        schermataSurvival.setPreferredSize(dimesioneFinestra);
        schermataSurvival.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SurvivalMode survivalMode = new SurvivalMode(schermataSurvival,difficolta);
        schermataSurvival.add(survivalMode);
        schermataSurvival.addKeyListener(survivalMode);
        schermataSurvival.pack();
        schermataSurvival.setVisible(true);

        Thread thread_gioco = new Thread(survivalMode);
        thread_gioco.start();
    }
}
