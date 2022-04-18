import java.util.ArrayList;
import java.util.List;

public class Garaje {
    int id;
    List listaVehiculos = new ArrayList<Vehiculo>();

    public Garaje(int id, List listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public List getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
