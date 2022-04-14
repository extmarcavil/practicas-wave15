package com.company;

import java.util.List;

public class Garaje {
    long id;
    List<Vehiculo> vehiculos;

    public Garaje(long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
