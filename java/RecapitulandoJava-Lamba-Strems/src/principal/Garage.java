package principal;

import java.util.*;

public class Garage {

    private static int id=0;
    private List<Vehiculo> vehiculos;

    public Garage () {}

    public Garage(List<Vehiculo> vehiculos) {
        this.id ++;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String toString() {
        return "Garage{" + "id=" + id + ", vehiculos=" + vehiculos + '}';
    }
}
