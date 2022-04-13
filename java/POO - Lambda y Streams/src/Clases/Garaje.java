package Clases;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    int id;
    List<Vehiculo> listado;

    public Garaje(int id, List<Vehiculo> listado) {
        this.id = id;
        this.listado = listado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Vehiculo> listado) {
        this.listado = listado;
    }
}
