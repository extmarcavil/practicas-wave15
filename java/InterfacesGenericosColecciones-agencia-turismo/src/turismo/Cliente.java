package turismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String dni;
    List<Localizador> localizadores = new ArrayList<>();

    public Cliente(String dni) {
        this.dni = dni;}

    public Localizador getLocalizador(int index) {
        return localizadores.get(index);
    }

    public void addLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }
}
