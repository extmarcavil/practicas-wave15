package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantVehiculosPermitidos;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public void darDeAlta(Vehiculo veh) {
        if(this.vehiculos.size() <= cantVehiculosPermitidos)
            this.vehiculos.add(veh);
    }

    public void eliminar(Vehiculo veh) {
        vehiculos.remove(veh);
    }

    public void eliminar(String patente) {
        try {
            vehiculos.remove(vehiculos.stream().filter(x -> Objects.equals(x.patente, patente)).findFirst().get());
        } catch (NoSuchElementException e) {
            System.out.println("No existe el vehículo a eliminar");
        }
    }

    public Vehiculo definirGanador() {
        Vehiculo vehiculo = null;
        double resultado = 0, resultadoAux = 0;

        for(Vehiculo veh : this.vehiculos) {
            resultadoAux = veh.velocidad * veh.aceleracion / 2 / (veh.anguloGiro * (veh.peso - veh.ruedas * 100));
            if(resultadoAux > resultado) {
                resultado = resultadoAux;
                vehiculo = veh;
            }
        }

        return vehiculo;

    }

    private Vehiculo obtenerVehiculo(String patente) {
        Vehiculo veh = vehiculos.stream().filter(x -> Objects.equals(x.patente, patente)).findFirst().get();
        return veh;
    }

    public void socorrerAuto(String patente) {
        Vehiculo veh = this.obtenerVehiculo(patente);
        Socorrista.socorrer((Auto)veh);
    }

    public void socorrerMoto(String patente) {
        Vehiculo veh = this.obtenerVehiculo(patente);
        Socorrista.socorrer((Moto)veh);
    }

}
