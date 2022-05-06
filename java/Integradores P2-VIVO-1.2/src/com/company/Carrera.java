package com.company;

import com.company.socorrer.SocorristaDeVehiculos;
import com.company.vehiculo.Vehiculo;
import com.company.vehiculo.VehiculoAuto;
import com.company.vehiculo.VehiculoMoto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Carrera {


    /**
     * Atributos.
     */
    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    /**
     * Agregando un Socorrista para la carrera.
     */
    private SocorristaDeVehiculos socorrista;

    /**
     * Constructor.
     */
    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorrista = new SocorristaDeVehiculos();
    }

    /**
     * Agregando un vehiculo tipo Auto o tipo Moto a la Carrera.
     */
    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new VehiculoAuto(velocidad, aceleracion, patente, anguloDeGiro));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new VehiculoAuto(velocidad, aceleracion, patente, anguloDeGiro));
        }
    }

    /**
     * Eliminando Vehiculos de la Carrera.
     */
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaDeVehiculos.contains(vehiculo)) {
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo Eliminado de la carrera");

        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        if (!listaDeVehiculos.isEmpty()) {
            listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente));
            System.out.println("Vehiculo con patente: " + patente + " Fue Eliminado de la carrera");
        }
    }

    /**
     * Definiendo Metodo para conocer la distancia maxima recorrida de cada vehiculo.
     */
    public double determinarDistanciaMaximaRecorrida(Vehiculo v) {
        double distanciaRecorrida = 0.0;
        if (v != null) {
            distanciaRecorrida = (v.getVelocidad() * (0.5 * v.getAceleracion())) / (v.getAnguloDeGiro() * (v.getPeso() - (v.getRuedas() * 100)));
        }
        return distanciaRecorrida;
    }

    /**
     * Definiendo el metodo para conocer el ganador de una carrera.
     * Utiliza el metodo determinarGanador() el cual contiene la logica para calcular la distancia maxima.
     */
    public String conocerGanador() {
        Vehiculo ganador = null;
        double distanciaMaximaRecorrida = 0.0;

        for (Vehiculo v : listaDeVehiculos) {
            double distanciaRecorrida = determinarDistanciaMaximaRecorrida(v);
            if (distanciaRecorrida > distanciaMaximaRecorrida) {
                distanciaMaximaRecorrida = distanciaRecorrida;
                ganador = v;
            }
        }
        return "El ganador fue el vehiculo: " + ganador + " con una distancia maxima de: " + distanciaMaximaRecorrida + " Km" + "\n";
    }

    /**
     * Agregando la funcionalidad de Buscar vehiculo por Patente.
     */
    public Vehiculo buscarVehiculo(String patente) {
        Vehiculo vehiculo = null;
        try {
            vehiculo = listaDeVehiculos.stream().filter(v -> v.getPatente().equalsIgnoreCase(patente)).findFirst().orElseThrow();
        } catch (Exception e) {
            System.out.println("El vehiculo no esta registrado en la carrera"+"\n");
        }
        return vehiculo;
    }

    /**
     * Responsabilidad del socorrista en la carrera.
     * Usando el metodo buscar Vehiculo por patente.
     */
    public void socorrerVehiculo(String patente) {
        Vehiculo v = buscarVehiculo(patente);
        if (v instanceof VehiculoAuto) {
            socorrista.socorrer(v);
        } else if (v instanceof VehiculoMoto) {
            socorrista.socorrer(v);
        }
    }

}
