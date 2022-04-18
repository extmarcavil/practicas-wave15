package models;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {

    private List<Localizador> localizadores;

    public RepositorioLocalizador() {
        localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public void imprimirLocalizadores(){
        localizadores.forEach(localizador -> {
            System.out.println(localizador);
        });
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "RepositorioLocalizador{" +
                "localizadores=" + localizadores +
                '}';
    }
}
