package Recap.Java.Vivo;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private Integer id;
    private List<Vehiculo> vehiculos;


    public Garage(Integer id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Garage(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
