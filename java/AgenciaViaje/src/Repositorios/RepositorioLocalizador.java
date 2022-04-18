package Repositorios;

import Modelo.Localizador;

import java.util.ArrayList;

public class RepositorioLocalizador implements Repositorio<Localizador>{

    private ArrayList<Localizador> listado_localizadores;

    public RepositorioLocalizador() {
        listado_localizadores = new ArrayList<>();
    }

    public ArrayList<Localizador> getListado_localizadores() {
        return listado_localizadores;
    }

    public void setListado_localizadores(ArrayList<Localizador> listado_localizadores) {
        this.listado_localizadores = listado_localizadores;
    }


    @Override
    public void agregar(Localizador servicio) {
        listado_localizadores.add(servicio);
    }
}
