package Main;

import java.util.ArrayList;

public class Garage {
    String id;
    ArrayList<Vehiculo> vehiculos;

    public void Garage(String id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
