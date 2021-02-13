package it.unimol.Grafica;

import it.unimol.ListaPunteggio;
import it.unimol.Punteggio;
import it.unimol.Salvataggio.SalvataggioFile;

import javax.swing.*;
import java.awt.*;

public class Vittoria {
    private JPanel vittoriaPanel;

    public Vittoria(int punteggio){
        Punteggio punteggio1 = new Punteggio();
        punteggio1.setPunteggio(punteggio);
        ListaPunteggio listaPunteggio = ListaPunteggio.getInstance();
        listaPunteggio.listaPunteggio.add(punteggio1);
        SalvataggioFile salvataggioFile = new SalvataggioFile();
        salvataggioFile.salvaPunteggio(listaPunteggio.listaPunteggio);
        frameVittoria();
    }

    private JPanel getVittoriaPanel() {
        return vittoriaPanel;
    }

    private void frameVittoria() {
        JFrame framerecord = new JFrame();
        framerecord.setSize(800, 720);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        framerecord.setLocation(0,0);

        framerecord.add(getVittoriaPanel());
        framerecord.setVisible(true);
    }



}
