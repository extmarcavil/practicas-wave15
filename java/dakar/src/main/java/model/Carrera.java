package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitodos;
    private List<Vehiculo> vehiculos;
    private Socorrista socorrista;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitodos,
                   Socorrista socorrista) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitodos = cantidadDeVehiculosPermitodos;
        this.socorrista = socorrista;
        this.vehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(Auto auto) {
        validarCupo(auto);
    }

    public void darDeAltaMoto(Moto moto) {
        validarCupo(moto);
    }

    private void validarCupo(Vehiculo vehiculo) {
        if (vehiculos.size() < cantidadDeVehiculosPermitodos) {
            vehiculos.add(vehiculo);
        } else {
            System.out.println("No hay cupos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.vehiculos.stream()
                .filter(buscarVehiculoPorPatente(unaPatente))
                .findFirst()
                .ifPresentOrElse(vehiculoEncontrado -> this.vehiculos.remove(vehiculoEncontrado),
                        () -> System.out.println("Vehiculo con patente: "+unaPatente+" no encontrado"));
    }

    private Predicate<Vehiculo> buscarVehiculoPorPatente(String unaPatente) {
        return vehiculo -> vehiculo.getPatente().equals(unaPatente);
    }

    public Vehiculo determinarGanador() {
        return this.vehiculos.stream()
                .max(Comparator.comparing(Vehiculo::getMax))
                .get();
    }

    public void socorrerAuto(String patente) {
        this.vehiculos.stream()
                .filter(buscarVehiculoPorPatente(patente))
                .findFirst()
                .ifPresentOrElse(vehiculoEncontrado -> this.socorrista.socorrer(vehiculoEncontrado),
                        () -> System.out.println("Vehiculo con patente: "+patente+" no encontrado"));

    }

    public void socorrerMoto(String patente) {

    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitodos() {
        return cantidadDeVehiculosPermitodos;
    }

    public void setCantidadDeVehiculosPermitodos(int cantidadDeVehiculosPermitodos) {
        this.cantidadDeVehiculosPermitodos = cantidadDeVehiculosPermitodos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
