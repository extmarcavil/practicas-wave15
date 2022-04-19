package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Carrera {
    private double distancia;
    private Integer premio;
    private Integer cantVehiculosPermitidos;
    private String nombre;
    private HashMap<String, Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, Integer premio, Integer cantVehiculosPermitidos, String nombre) {
        this.distancia = distancia;
        this.premio = premio;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.nombre = nombre;
        this.listaDeVehiculos = new HashMap<String, Vehiculo>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Carrera() {
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Integer getPremio() {
        return premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

    public Integer getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(Integer cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(HashMap<String, Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premio=" + premio +
                ", cantVehiculosPermitidos=" + cantVehiculosPermitidos +
                ", nombre='" + nombre + '\'' +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }

    private boolean hayLugar(){
        return listaDeVehiculos.size() < cantVehiculosPermitidos;
    }

    private boolean estaRepetido(String patente){
        return listaDeVehiculos.containsKey(patente);
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(!hayLugar() || estaRepetido(patente)){
            System.out.println("No se ha podido agregar el auto a la carrera");
        }else{
            Auto auto = new Auto(velocidad, aceleracion, anguloGiro, patente);
            System.out.println(auto.getPerformance());
            listaDeVehiculos.put(patente, auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(!hayLugar() || estaRepetido(patente)){
            System.out.println("No se ha podido agregar la moto a la carrera");
        }else{
            Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            System.out.println(moto.getPerformance());
            listaDeVehiculos.put(patente, moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo.getPatente());
    }

    public void eliminarVehiculoPorPatente(String patente){
        listaDeVehiculos.remove(patente);
    }

    public void definirGanador(){
        Map.Entry ganador = (Map.Entry)(listaDeVehiculos.entrySet().stream()
                .max(Comparator.comparing(c -> c.getValue().getPerformance()))
                .get());
        System.out.println(ganador.getValue());
    }

    public void socorrerAuto(String patente){
        this.socorristaAuto.socorrer(listaDeVehiculos.get(patente));
    }

    public void socorrerMoto(String patente){
        this.socorristaMoto.socorrer(listaDeVehiculos.get(patente));
    }
}
