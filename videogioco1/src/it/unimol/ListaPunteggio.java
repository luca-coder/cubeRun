package it.unimol;

import java.util.ArrayList;

public class ListaPunteggio {
    private static ListaPunteggio instance = null;

    public ArrayList<Punteggio> listaPunteggio;

    private ListaPunteggio(){
        this.listaPunteggio = new ArrayList<>();
    }

    public static ListaPunteggio getInstance(){
        if (instance == null) {
            instance = new ListaPunteggio();
        }
        return instance;
    }

    public void ordinaClassifica(ArrayList<Punteggio> classifica){
        classifica.sort(new Punteggio());
    }
}
