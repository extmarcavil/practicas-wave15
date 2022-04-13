package ejercicioVehiculosGaraje;

import java.util.ArrayList;

public class Garaje {
    private int id;
    private ArrayList<Vehiculo> listaVehiculos;


    public Garaje(int id, ArrayList<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }


    public Garaje(int id) {
        this.id = id;
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
