package it.unimol.Grafica;

import javax.swing.*;
import java.awt.*;

public class Sconfitta {

    private JPanel SconfittaPanel;

    public Sconfitta(){
        frameSconfitta();
    }

    private JPanel getSconfittaPanel() {
        return SconfittaPanel;
    }

    private void frameSconfitta() {
        JFrame framerecord = new JFrame();
        framerecord.setSize(800, 720);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        framerecord.setLocation(0,0);

        framerecord.add(getSconfittaPanel());
        framerecord.setVisible(true);
    }

}
