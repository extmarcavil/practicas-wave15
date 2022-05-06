package com.company;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    private int id;
    List<Vehiculo> listaDeVehiculos;

    public Garaje(int id, List<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Garaje() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }
}
