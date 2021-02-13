package it.unimol.gioco;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurvivalModeTest {
    @Test
    void calcolaPunteggio(){
        JFrame jFrame = new JFrame();
        int difficolta = 10;
        SurvivalMode survivalMode = new SurvivalMode(jFrame, difficolta);
        int res = survivalMode.calcolaPunteggio(difficolta);
        assertEquals(res, 100);
    }
}