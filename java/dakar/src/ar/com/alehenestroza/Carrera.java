package ar.com.alehenestroza;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public Set<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(Set<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            if (!this.listaDeVehiculos.add(auto)) {
                System.out.println("Registro fallido. Este auto ya se encuentra registrado.");
            } else {
                System.out.println("Registro exitoso.");
            }
        } else {
            System.out.println("Registro fallido. No hay mas capacidad en la carrera.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            if (!this.listaDeVehiculos.add(moto)) {
                System.out.println("Registro fallido. Este moto ya se encuentra registrado.");
            } else {
                System.out.println("Registro exitoso.");
            }
        } else {
            System.out.println("Registro fallido. No hay mas capacidad en la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoPorPatente(String patente) {
        this.listaDeVehiculos.removeIf(p -> p.getPatente().equals(patente));
    }

    private double getScore(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * 1/2 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() *100));
    }

    public Vehiculo getGanador() {
        return this.listaDeVehiculos.stream()
                .max(Comparator.comparingDouble(this::getScore))
                .orElse(null);
    }

    public void socorrerAuto(String patente) {
        Vehiculo auto = this.listaDeVehiculos.stream()
                .filter(p -> p.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if (auto == null) {
            System.out.println("No se encontro un vehiculo con esa patente.");
        } else {
            if (auto instanceof Auto) {
                this.socorristaAuto.socorrer((Auto) auto);
            } else {
                System.out.println("El vehiculo es una moto. Por favor, llame al socorrista de motos.");
            }
        }
    }

    public void socorrerMoto(String patente) {
        Vehiculo moto = this.listaDeVehiculos.stream()
                .filter(p -> p.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if (moto == null) {
            System.out.println("No se encontro un vehiculo con esa patente.");
        } else {
            if (moto instanceof Moto) {
                this.socorristaMoto.socorrer((Moto) moto);
            } else {
                System.out.println("El vehiculo es un auto. Por favor, llame al socorrista de autos.");
            }
        }
    }
}
