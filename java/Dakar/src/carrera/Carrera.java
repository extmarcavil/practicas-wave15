package carrera;

import modelos.Auto;
import modelos.Moto;
import modelos.Socorrista;
import modelos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> vehiculosInscritos;
    private Socorrista socorristaAuto;
    private Socorrista socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantVehiculosPermitidos, Socorrista socorristaAuto,
                   Socorrista socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        vehiculosInscritos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantVehiculosPermitidos > vehiculosInscritos.size()) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculosInscritos.add(auto);
        } else {
            System.out.println("Vehiculo no ingresado. No hay mas cupos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (cantVehiculosPermitidos > vehiculosInscritos.size()) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculosInscritos.add(moto);
        } else {
            System.out.println("Vehiculo no ingresado. No hay mas cupos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculosInscritos.contains(vehiculo)) {
            vehiculosInscritos.remove(vehiculo);
            System.out.println("Vehiculo eliminado.");
        }
        else
            System.out.println("Vehiculo no inscrito");
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Vehiculo vehiculoAEliminar = null;
        for (Vehiculo vehiculo : vehiculosInscritos)
            if (vehiculo.getPatente().equals(unaPatente))
                vehiculoAEliminar = vehiculo;
        if (vehiculoAEliminar != null) {
            vehiculosInscritos.remove(vehiculoAEliminar);
            System.out.println("Vehiculo eliminado");
        }

    }

    public void definirGanador() {
        double resultadoFinal = 0;
        double resultadoParcial = 0;
        Vehiculo vehiculoGanador = null;
        for (Vehiculo vehiculo : vehiculosInscritos) {
            resultadoParcial = (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) /
                                (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (resultadoFinal < resultadoParcial){
                resultadoFinal = resultadoParcial;
                vehiculoGanador = vehiculo;
            }
        }
        System.out.println("Vehiculo ganador");
        System.out.println(vehiculoGanador);
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : vehiculosInscritos)
            if (vehiculo.getPatente().equals(patente))
                socorristaAuto.socorrer(vehiculo);
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : vehiculosInscritos)
            if (vehiculo.getPatente().equals(patente))
                socorristaMoto.socorrer(vehiculo);
    }
}
