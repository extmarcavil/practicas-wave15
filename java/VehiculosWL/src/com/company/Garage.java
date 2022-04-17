package com.company;

import java.util.List;

public class Garage {
    private String id;
    private List<Vehicle> vehicles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Garage(String id, List<Vehicle> parqueadero) {
        this.id = id;
        this.vehicles = parqueadero;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id='" + id + '\'' +
                ", parqueadero=" + vehicles +
                '}';
    }
}
