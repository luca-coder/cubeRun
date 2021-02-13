package it.unimol.Grafica;

import it.unimol.GestoreCaricamenti.CaricatoreTutorial;
import it.unimol.ListaPunteggio;
import it.unimol.Punteggio;
import it.unimol.Salvataggio.CaricamentoFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * classe che descrive la prima finestra creata all'inizio del gioco, che comprende i pulsanti per iniziare le 2 modalità di gioco, per uscire dal gioco e per mostare la classifica
 */
public class Home {
    private JButton survivalButton;
    private JButton esciButton;
    private JPanel homePanel;
    private JButton tutorialButton;
    private JTextArea areaClassifica;

    /**
     * costruttore della classe nel quale vengono descritti i bottoni che chiameranno le successive funzioni
     * @param finestraGioco la finestra home chiamata ne main
     */
    public Home(JFrame finestraGioco) {

        CaricamentoFile caricamentoFile = new CaricamentoFile();
        ListaPunteggio listaPunteggio = ListaPunteggio.getInstance();
        listaPunteggio.listaPunteggio = caricamentoFile.caricaPunteggio(listaPunteggio.listaPunteggio);

        esciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        survivalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SceltaDifficoltà(finestraGioco);
            }
        });

        tutorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CaricatoreTutorial(finestraGioco);
            }
        });

        areaClassifica.append("TOP 10 PUNTEGGI\n");
        ArrayList<Punteggio> listaOrdinata = listaPunteggio.listaPunteggio;
        listaPunteggio.ordinaClassifica(listaOrdinata);
        int i = 0;
        for (Punteggio punteggio:listaOrdinata) {
            if (i == 10)
                break;
            areaClassifica.append(mostraClassifica(punteggio));
            i++;
        }
    }

    private String mostraClassifica(Punteggio punteggio) {
        return punteggio.getPunteggio() + ";\n";
    }

    public JPanel getHomePanel() {
        return homePanel;
    }

}
