package Clases;

import java.util.ArrayList;

public class Localizador<T>{
    private ArrayList<T> localizador;
    private Cliente cliente;
    private double total;


    public Localizador(ArrayList<T> localizador) {
        this.localizador = localizador;
    }

    public ArrayList<T> getLocalizador() {
        return localizador;
    }

    public void setLocalizador(ArrayList<T> localizador) {
        this.localizador = localizador;
    }
}
