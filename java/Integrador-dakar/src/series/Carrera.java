package series;

import java.util.Collections;
import java.util.List;

public class Carrera {
    double distancia;
    double premioEnDolares;
    String nombre;
    int cantidadVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    Vehiculo vehiculoGanador;

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(validarCupo()){
            Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(validarCupo()){
            Auto auto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }

    private boolean validarCupo(){
        return vehiculos.size() + 1 <= cantidadVehiculosPermitidos;
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente() == unaPatente);
    }

    public void setGanador(Vehiculo vehiculo){
        this.vehiculoGanador = vehiculo;
    }

    public Vehiculo getGanador(){
        vehiculos.stream().map(vehiculo -> {
            double calculo = 0;
            if(vehiculo.getCalculo() > calculo) setGanador(vehiculo);
            return null;
        });

        return this.vehiculoGanador;
    }

}
