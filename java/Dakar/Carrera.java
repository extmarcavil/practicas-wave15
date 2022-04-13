package Dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        if (hayCupos()) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente.toUpperCase());
            vehiculos.add(auto);
        } else {
            System.out.println("No hay cupos para agregar el auto con patente " + patente.toUpperCase());
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        if (hayCupos()) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente.toUpperCase());
            vehiculos.add(moto);
        } else {
            System.out.println("No hay cupos para agregar la moto con patente " + patente.toUpperCase());
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoARemover = buscarVehiculoByPatente(patente);
        vehiculos.remove(vehiculoARemover);
    }

    public Vehiculo ganador() {
        return this.vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::obtenerValor)).get();
    }

    public void getSocorristaAuto(Auto auto) {
        Vehiculo vehiculoARemover = buscarVehiculoByPatente(auto.getPatente());
        socorristaAuto.socorrer((Auto) vehiculoARemover);
    }

    public void getSocorristaMoto(Moto moto) {
        Vehiculo vehiculoARemover = buscarVehiculoByPatente(moto.getPatente());
        socorristaMoto.socorrer((Moto) vehiculoARemover);
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    private Vehiculo buscarVehiculoByPatente(String patente) {
        return vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .get();
    }

    private boolean hayCupos() {
        return vehiculos.size() < cantidadDeVehiculosPermitidos;
    }
}
