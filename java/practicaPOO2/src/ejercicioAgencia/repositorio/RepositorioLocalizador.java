package ejercicioAgencia.repositorio;

import ejercicioAgencia.Localizador;

import java.util.ArrayList;

public class RepositorioLocalizador {
    private ArrayList<Localizador> lstLocalizadores;

    public RepositorioLocalizador() {
        this.lstLocalizadores = new ArrayList<>();
    }

    public void guardarLocalizador(Localizador localizador) {
        this.lstLocalizadores.add(localizador);
    }

    public ArrayList<Localizador> getLstLocalizadores() {
        return lstLocalizadores;
    }

    public void setLstLocalizadores(ArrayList<Localizador> lstLocalizadores) {
        this.lstLocalizadores = lstLocalizadores;
    }
}
