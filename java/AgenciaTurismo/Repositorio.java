package AgenciaTurismo;

import java.util.ArrayList;

public class Repositorio {

    private ArrayList<Localizador> localizadores;

    public ArrayList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(ArrayList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador (Localizador local){
        localizadores.add(local);
    }
}
