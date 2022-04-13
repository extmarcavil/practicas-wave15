package automotora;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> listado = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListado() {
        return listado;
    }

    public void setListado(List<Vehiculo> listado) {
        this.listado = listado;
    }

    public Garage(int id, List<Vehiculo> listado) {
        this.id = id;
        this.listado = listado;
    }
}
