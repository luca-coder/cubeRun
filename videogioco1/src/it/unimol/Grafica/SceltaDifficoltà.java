package it.unimol.Grafica;

import it.unimol.GestoreCaricamenti.CaricatoreSurvival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * classe che descrive il frame che compare prima dell' inizio della modalità survival, nel quale verrà inserito il numero di ostacoli generati; successivamente caricherà il frame della modalità tutorial
 */
public class SceltaDifficoltà {
    private JPanel panel1;
    private JButton giocaButton;
    private JTextField textField1;
    private int difficolta;

    /**
     * costruttore della classe che legge il valore passato in input e carica il frame della modalità survival
     * @param jFrame il Jframe della home che viene settato a non visibile
     */
    public SceltaDifficoltà(JFrame jFrame) {
        jFrame.setVisible(false);
        JFrame frame = frameDifficolta();
        giocaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                difficolta = Integer.parseInt(textField1.getText());
                if (difficolta == 0)
                    try {
                        throw new Exception();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                new CaricatoreSurvival(frame, difficolta);
            }
        });
    }

    private JPanel getPanel1() {
        return panel1;
    }

    private JFrame frameDifficolta(){
        JFrame framerecord = new JFrame();
        framerecord.setSize(800, 720);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        framerecord.setLocation(0,0);

        framerecord.add(getPanel1());
        framerecord.setVisible(true);
        return framerecord;
    }

}
