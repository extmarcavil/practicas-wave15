package Dakar;

import java.util.List;
import java.util.Map;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private Map<String, Vehiculo> listaVehiculos;
    private SocorristaAuto socAuto = new SocorristaAuto();
    private SocorristaMoto socMoto = new SocorristaMoto();

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos, Map<String, Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (listaVehiculos.size() < cantidadVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.put(patente, auto);
        } else {
            System.out.println("Capacidad colmada");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (listaVehiculos.size() < cantidadVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.put(patente, moto);
        } else {
            System.out.println("Capacidad colmada");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        this.eliminarVehiculo(v.getPatente());
    }

    public void eliminarVehiculo(String patente){
        if (listaVehiculos.containsKey(patente)){
            listaVehiculos.remove(patente);
            System.out.println("Vehículo eliminado");
        } else {
            System.out.println("Vehículo no encontrado");
        }
    }

    public Vehiculo getGanador(){
        Vehiculo ganador = null;
        float max = Integer.MIN_VALUE;
        for (Vehiculo v : listaVehiculos.values()){
            if (v.coeficienteGanador() > max){
                ganador = v;
                max = v.coeficienteGanador();
            }
        }
        return ganador;
    }

    public void socorrerAuto (String patente){
        Vehiculo vehiculo = listaVehiculos.get(patente);
        if ((vehiculo != null) && (vehiculo instanceof Auto) ){
            socAuto.socorrer((Auto) vehiculo);
        } else {
            System.out.println("Patente incorrecta");
        }
    }

    public void socorrerMoto (String patente){
        Vehiculo vehiculo = listaVehiculos.get(patente);
        if ((vehiculo != null) && (vehiculo instanceof Moto) ){
            socMoto.socorrer((Moto) vehiculo);
        } else {
            System.out.println("Patente incorrecta");
        }


    }
}
