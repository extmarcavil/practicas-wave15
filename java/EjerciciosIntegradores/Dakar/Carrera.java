package EjerciciosIntegradores.Dakar;

import java.util.HashMap;
import java.util.Map;

public class Carrera {
    private double distancia;
    private Integer premio;
    private Integer cantVehiculosPermitidos;
    private String nombre;
    private HashMap<String, Vehiculo> listaDeVehiculos;

   public Carrera(double distancia, Integer premio, Integer cantVehiculosPermitidos, String nombre, HashMap<String, Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.nombre = nombre;
        this.listaDeVehiculos = listaDeVehiculos;
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
        return this.listaDeVehiculos.size() < cantVehiculosPermitidos;
    }

    private boolean estaRepetido(String patente){
        return listaDeVehiculos.containsKey(patente);
    }

    private boolean checkEntrada(String patente){
        if(!hayLugar() ){
            System.out.println("Ya no quedan lugares en la carrera");
        }else if( estaRepetido(patente)){
            System.out.println("El auto ya esta en la carrera");
        }else{
            return true;
        }
        return false;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(checkEntrada(patente)){
            Auto auto = new Auto(velocidad, aceleracion, anguloGiro, patente);
            System.out.println("Auto ingresado!");
            listaDeVehiculos.put(patente, auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(checkEntrada(patente)){
            Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            listaDeVehiculos.put(patente, moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo.getPatente());
    }

    public void eliminarVehiculoPorPatente(String patente){
        listaDeVehiculos.remove(patente);
    }

    ///Get vehiculo with most getPerformance

    public Vehiculo definirGanador(){
        Vehiculo vehiculoConMayorPerformance = null;
        double mayorPerformance = 0;
        for(Map.Entry<String, Vehiculo> vehiculo : listaDeVehiculos.entrySet()){
            if(vehiculo.getValue().getPerformance() > mayorPerformance){
                vehiculoConMayorPerformance = vehiculo.getValue();
                mayorPerformance = vehiculo.getValue().getPerformance();
            }
        }
        return vehiculoConMayorPerformance;
    }



 }

