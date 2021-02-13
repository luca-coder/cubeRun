package it.unimol.Salvataggio;

import it.unimol.Punteggio;

import java.io.*;
import java.util.ArrayList;

public class SalvataggioFile {

    public void salvaPunteggio(ArrayList<Punteggio> classifica) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("classifica.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(classifica);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
