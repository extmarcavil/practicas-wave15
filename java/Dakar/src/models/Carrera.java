package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Carrera {
    private Float distancia;
    private Float premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private  SocorristaMoto socorristaMoto;

    public Carrera(Float distancia, Float premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        this.darDeAltaVehiculo(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        this.darDeAltaVehiculo(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculo(String patente) {
        this.vehiculos = this.vehiculos
                .stream()
                .filter(v -> v.getPatente().equals(patente))
                .collect(Collectors.toList());
    }

    public void socorrerAuto(String patente) {
        this.vehiculos
                .stream()
                .filter(v -> v.getPatente().equals(patente))
                .findAny()
                .ifPresentOrElse(v -> {
                    if (v instanceof Auto) {
                        this.socorristaAuto.socorrer((Auto) v);
                    } else {
                        System.out.println("Yo no socorro motos :(");
                    }
                }, () -> {
                    System.out.println("No existe un auto con esa patente");
                });
    }

    private void socorrerMoto(String patente) {
        this.vehiculos
                .stream()
                .filter(v -> v.getPatente().equals(patente))
                .findAny()
                .ifPresentOrElse(v -> {
                    if (v instanceof Moto) {
                        this.socorristaMoto.socorrer((Moto) v);
                    } else {
                        System.out.println("Yo no socorro autos :(");
                    }
                }, () -> {
                    System.out.println("No existe una moto con esa patente");
                });
    }

    public Vehiculo ganador() {
        return this.vehiculos
                .stream()
                .reduce(null, (acc, v) -> {
                   if (acc == null)
                       return v;
                   else
                       return ganadorEntre(acc, v);
                });
    }

    private Vehiculo ganadorEntre(Vehiculo v1, Vehiculo v2) {
        return this.puntosGanadores(v1) > this.puntosGanadores(v2) ? v1 : v2;
    }

    private double puntosGanadores(Vehiculo v) {
        return (v.getVelocidad() * (v.getAceleracion() / 2)) /
                (v.getAnguloDeGiro() * (v.getPeso() - (v.getRuedas() * 100)));
    }

    private void darDeAltaVehiculo(Vehiculo vehiculo) {
        if (!this.hayLugar()) {
            System.out.println("Ya no hay lugar en la carrera");
        } else if (!this.isVehiculoPresente(vehiculo)) {
            this.vehiculos.add(vehiculo);
            System.out.println("Se agrego a la carrera el vehiculo " + vehiculo);
        } else {
            System.out.println("Ese vehiculo ya esta en la carrera");
        }
    }

    private boolean hayLugar() {
        return this.vehiculos.size() < this.cantidadDeVehiculosPermitidos;
    }

    private boolean isVehiculoPresente(Vehiculo vehiculo) {
        return this.vehiculos
                .stream()
                .anyMatch(v -> v.getPatente().equals(vehiculo.getPatente()));
    }
}
