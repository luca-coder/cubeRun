package it.unimol.GestoreCaricamenti;

import it.unimol.gioco.TutorialMode;

import javax.swing.*;
import java.awt.*;
/**
 * classe che crea il frame della modalità tutorial e fa partire il thread nel quale viene chiamata
 */
public class CaricatoreTutorial {
    /**
     * costruttore della classe che crea un nuovo JFrame che opsiterà la modalitò tutorial e crea un nuovo thread nel quale verrà chiamata
     * @param finestraGioco la finestra home che verrà settata a non visibile
     */
    public CaricatoreTutorial(JFrame finestraGioco){
        finestraGioco.setVisible(false);

        JFrame schermataGioco = new JFrame();

        Dimension dimesioneFinestra = new Dimension(TutorialMode.larghezza, TutorialMode.altezza);
        schermataGioco.setPreferredSize(dimesioneFinestra);
        schermataGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TutorialMode tutorialMode = new TutorialMode(schermataGioco);
        schermataGioco.add(tutorialMode);
        schermataGioco.addKeyListener(tutorialMode);
        schermataGioco.pack();
        schermataGioco.setVisible(true);

        Thread thread_gioco = new Thread(tutorialMode);
        thread_gioco.start();
    }
}
