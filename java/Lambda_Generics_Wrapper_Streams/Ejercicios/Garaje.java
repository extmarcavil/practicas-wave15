package Lambda_Generics_Wrapper_Streams.Ejercicios;

import java.util.ArrayList;

public class Garaje {
    private int id;
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(int id, ArrayList<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
