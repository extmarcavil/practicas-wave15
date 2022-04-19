package ejercicioVehiculoGenericsLambda;

import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
    }

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
