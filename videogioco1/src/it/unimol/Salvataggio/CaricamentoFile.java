package it.unimol.Salvataggio;

import it.unimol.Punteggio;

import java.io.*;
import java.util.ArrayList;

public class CaricamentoFile {

    private File file = new File("classifica.txt");

    public ArrayList<Punteggio> caricaPunteggio(ArrayList<Punteggio> classifica){
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            if (!this.file.exists()){
                file.createNewFile();
            }else{
                classifica = (ArrayList<Punteggio>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classifica;
    }
}
