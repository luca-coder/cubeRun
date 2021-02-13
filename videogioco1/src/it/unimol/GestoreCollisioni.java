package it.unimol;

import it.unimol.oggetti.Quadrato;
import it.unimol.oggetti.Triangolo;

public class GestoreCollisioni {

    public static boolean controllaCollisione(Triangolo triangolo, Quadrato quadrato){
        return triangolo.getBordi().intersects(quadrato.getBordi());
    }
}