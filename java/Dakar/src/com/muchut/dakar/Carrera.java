package com.muchut.dakar;

import java.util.ArrayList;

public class Carrera {
    private int distancia, premioEnDolares, cantidadDeVehiculosPermitidos;
    private String nombre;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Autos nuevoAuto = new Autos(velocidad, aceleracion, anguloDeGiro, 0, 0, patente);
    }
    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Motos nuevoAuto = new Motos(velocidad, aceleracion, anguloDeGiro, 0, 0, patente);
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Carrera(int distancia, int premioEnDolares, int cantidadDeVehiculosPermitidos, String nombre, ArrayList<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.nombre = nombre;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Carrera() {
    }
}
