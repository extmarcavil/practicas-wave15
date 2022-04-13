package com.company;

import com.company.vehiculos.Auto;
import com.company.vehiculos.Moto;
import com.company.vehiculos.Vehiculo;
import com.company.vehiculos.socorrista.SocorristaAuto;
import com.company.vehiculos.socorrista.SocorristaMoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia, premio;
    private String nombre;
    private int cantVehiPerm;
    List<Vehiculo> vehiculos;
    private SocorristaAuto socoAuto;
    private SocorristaMoto socoMoto;

    public Carrera(double distancia, double premio, String nombre, int cantVehiPerm, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantVehiPerm = cantVehiPerm;
        this.vehiculos = new ArrayList<>();

        socoAuto = new SocorristaAuto("sco 475");
        socoMoto = new SocorristaMoto("afs 541");
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,int AnguloDeGiro,String patente){
       if(cantVehiPerm <= vehiculos.size()){
         Vehiculo auto = new Auto(velocidad, aceleracion, 70, patente);
         vehiculos.add(auto);
       }else System.out.println("No hay mas lugar");
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,int AnguloDeGiro,String patente){
        if(cantVehiPerm <= vehiculos.size()){
            Vehiculo moto = new Moto(velocidad, aceleracion, 70, patente);
            vehiculos.add(moto);
        }else System.out.println("No hay mas lugar");
    }

    public void eliminarVehiculo(Vehiculo vehi){
        vehiculos.remove(vehi);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Optional<Vehiculo> vehiculoARemover = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if(vehiculoARemover.isPresent())
            vehiculos.remove(vehiculoARemover.get());
        else
            System.out.println("No se encontro al vehiculo con la patente: " + patente);
    }

    private Vehiculo buscarVehiculo(String patente) {
        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if(vehiculo.isEmpty())
            System.out.println("No se encontro al vehiculo con la patente: " + patente);

        return vehiculo.get();
    }

    public void socorrerAuto(String patente){
        socoAuto.socorrer((Auto)buscarVehiculo(patente));
    }

    public void socorrerMoto(String patente){
        socoMoto.socorrer((Moto)buscarVehiculo(patente));
    }
}
