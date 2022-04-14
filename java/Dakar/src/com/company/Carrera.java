package com.company;

import java.util.List;
import java.util.function.Predicate;

public class Carrera {

    private int distancia;
    private int premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;



    public void darDeAltaAuto(int velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(vehiculos.size() == cantidadVehiculosPermitidos){
            System.out.println("Cantidad de vehiculos alcanzada, no se pueden ingresar mas!");
        }else {
            Vehiculo carro = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 1000,4);
            vehiculos.add(carro);
        }
    }

    public void darDeAltaMoto(int velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(vehiculos.size() == cantidadVehiculosPermitidos){
            System.out.println("Cantidad de vehiculos alcanzada, no se pueden ingresar mas!");
        }else {
            Vehiculo moto = new Vehiculo(velocidad, aceleracion, anguloDeGiro, patente, 300,2);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){

        for (int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getPatente() == patente){
                vehiculos.remove(vehiculos.get(i));
            }else{
                System.out.println("Vehiculo no encontrado");
            }
        }
    }

//    selecciona un ganador realizando el calculo de Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    public void ganador(){
        Vehiculo vehiculo = null;
        double puntaje = 0;


        puntaje = vehiculos.stream()
                        .mapToInt(v -> (int) (v.getVelocidad() * (v.getAceleracion() / 2) / (v.getAnguloGiro() * (v.getPeso() - v.getRuedas())) * 100)).max().getAsInt();

        double finalPuntaje = puntaje;
        vehiculo = (Vehiculo) vehiculos.stream()
                .filter(v -> (v.getVelocidad() * (v.getAceleracion() / 2) / (v.getAnguloGiro() * (v.getPeso() - v.getRuedas())) * 100) >= finalPuntaje).findFirst().get();


        System.out.println("El ganador es: " + vehiculo.getPatente() + "con un puntaje de: " + puntaje);
    }

    Socorrista socorristaAuto = new SocorristaAuto();
    Socorrista socorristaMoto = new SocorristaMoto();
}
