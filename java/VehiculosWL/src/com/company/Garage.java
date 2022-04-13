package com.company;

import java.util.List;

public class Garage {
    private String id;
    private List<Vehiculo> parqueadero;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(List<Vehiculo> parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Garage(String id, List<Vehiculo> parqueadero) {
        this.id = id;
        this.parqueadero = parqueadero;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id='" + id + '\'' +
                ", parqueadero=" + parqueadero +
                '}';
    }
}
