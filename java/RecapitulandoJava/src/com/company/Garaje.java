package com.company;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculoList;
    //private List<Vehiculo> vehiculoList = new ArrayList<Vehiculo>();

    public Garaje() {
    }

    public Garaje(int id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }

    public Garaje(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public void addVehiculo(Vehiculo v){
        vehiculoList.add(v);
    }
}
