package com.muchut.dakar;

import java.util.ArrayList;

public class Carrera {
    private int distancia, premioEnDolares, cantidadDeVehiculosPermitidos;
    private String nombre;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Autos nuevoAuto = new Autos(velocidad, aceleracion, anguloDeGiro, 0, 0, patente);
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(nuevoAuto);
        } else {
            System.out.println("--Error. Ya no hay cupos para agregar el auto de patente " + nuevoAuto.patente);
            System.out.println("--Esta carrera es para " + cantidadDeVehiculosPermitidos + " vehículos");
        }
    }
    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        Motos nuevaMoto = new Motos(velocidad, aceleracion, anguloDeGiro, 0, 0, patente);
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(nuevaMoto);
        } else {
            System.out.println("--Error. Ya no hay cupos para agregar la moto de patente " + nuevaMoto.patente);
            System.out.println("--Esta carrera es para " + cantidadDeVehiculosPermitidos + " vehículos");
        }
        listaDeVehiculos.add(nuevaMoto);
    }

    // creo un socorrista de autos
    SocorristaAuto socorristaDeAuto = new SocorristaAuto();
    // creo el método para socorrer un auto
    public void socorrerAuto (String unaPatente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v.patente.equals(unaPatente)) {
                socorristaDeAuto.socorrer(((Autos) v));
            }
        }
    }
    // creo un socorrista de motos
    SocorristaMoto socorristaDeMoto = new SocorristaMoto();
    // creo el método para socorrer una moto
    public void socorrerMoto (String unaPatente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v.patente.equals(unaPatente)) {
                socorristaDeMoto.socorrer(((Motos) v));
            }
        }
    }

    // método para obtener puntaje de un vehiculo
    private double puntaje (Vehiculo v) {
        double resultado = ((v.getVelocidad() * v.getAceleracion()) / 2) / (v.getAnguloDeGiro() * (v.getPeso() - (v.getRuedas() * 100)));
        return resultado;
    }

    public String ganadorDeCarrera () {
        double puntajeAlto = 0D;
        String vehiculoGanador = null;
        for (Vehiculo v : listaDeVehiculos) {
            if (puntaje(v) > puntajeAlto) {
                puntajeAlto = puntaje(v);
                vehiculoGanador = v.patente;
            }
        }
        System.out.println("---------------");
        System.out.println("El ganador de la carrera es el vehículo con patente " + vehiculoGanador + " y se lleva Us$" + premioEnDolares);
        System.out.println("---------------");
        return vehiculoGanador;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", nombre='" + nombre + '\'' +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }

    public void eliminarVehiculo (Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente (String unaPatente) {
        System.out.println("Se va a eliminar el vehículo de patente " + unaPatente + "...");
        int antes = listaDeVehiculos.size();
        listaDeVehiculos.removeIf((c) -> c.patente.equals(unaPatente));
        int despues = listaDeVehiculos.size();
        if (antes > despues) {
            System.out.println("Se ha eliminado un vehículo con éxito");
        } else {
            System.out.println("--Error. No se ha podido eliminar el vehículo");
        }
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

}
