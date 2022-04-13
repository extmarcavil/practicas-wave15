package dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente,1000,4);
        if(cantidadVehiculosPermitidos < listaDeVehiculos.size())
            listaDeVehiculos.add(auto);
        else
            System.out.println("Sin cupo");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente,300,2);
        if(cantidadVehiculosPermitidos < listaDeVehiculos.size())
            listaDeVehiculos.add(moto);
        else
            System.out.println("Sin cupo");

    }
}
