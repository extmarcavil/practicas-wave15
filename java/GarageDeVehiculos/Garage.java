package GarageDeVehiculos;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

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

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void AgregarVehiculo (Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}
