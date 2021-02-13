package it.unimol;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class Punteggio implements Serializable,Comparator<Punteggio> {
    private int punteggio;

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public int compare(Punteggio o1, Punteggio o2) {
        return Integer.compare(o2.getPunteggio(), o1.getPunteggio());
    }

}
