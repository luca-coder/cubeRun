import it.unimol.Grafica.Home;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame finestraGioco = new JFrame("Cube run");
        Home home = new Home(finestraGioco);

        Dimension dimesioneFinestra = new Dimension(800, 700);
        finestraGioco.setPreferredSize(dimesioneFinestra);
        finestraGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        finestraGioco.add(home.getHomePanel());
        finestraGioco.pack();
        finestraGioco.setVisible(true);
    }
}
