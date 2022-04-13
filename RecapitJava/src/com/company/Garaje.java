package com.company;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    private int id;
    private ArrayList <Vehiculo> vehiculos;

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

    public Garaje(int id) {
        this.id = id;
        vehiculos = new ArrayList<>();
    }



}
