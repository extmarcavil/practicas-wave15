package AgenciaTurismo;

import java.util.ArrayList;

public class LocalizadorRepositorio implements Repositorio<Localizador>{
    ArrayList<Localizador> listadoLocalizadores = new ArrayList<>();
    @Override
    public void agregar(Localizador objeto) {
        listadoLocalizadores.add(objeto);
    }

    @Override
    public String toString() {
        return "LocalizadorRepositorio{" +
                "listadoLocalizadores=" + listadoLocalizadores +
                '}';
    }

    public ArrayList<Localizador> getListadoLocalizadores() {
        return listadoLocalizadores;
    }

    public void setListadoLocalizadores(ArrayList<Localizador> listadoLocalizadores) {
        this.listadoLocalizadores = listadoLocalizadores;
    }

    public Integer getCantidadLocalidazoresVendidos(){
        return listadoLocalizadores.size();
    }
    public Integer getCantidadReservas(){
        return listadoLocalizadores.stream()
                .mapToInt(l -> l.getPaquete().getCantidadReservas()).sum();
    }
}
