package dakar;

import model.Auto;
import model.Moto;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class CarreraDeVehiculos {

    private Double distancia;
    private Integer premio;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculosInscriptos;

    public CarreraDeVehiculos(Double distancia, Integer premio, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaDeVehiculosInscriptos = new ArrayList<>();
    }

    //Una carrera además tiene un conjunto de vehículos que participarán de la misma.
    //Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un
    //vehículo a la carrera, por lo que debemos definir los siguientes métodos:
    //public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    //public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    //Ambos métodos agregan un vehículo siempre y cuando haya cupo.

    public void darDeAltaAuto( Auto autoPorInscribir ){
        if( listaDeVehiculosInscriptos.size() < cantidadVehiculosPermitidos ){
            listaDeVehiculosInscriptos.add(autoPorInscribir);
            System.out.println("Auto inscripto correctamente");
        }else{
            System.out.println("Cupo excedido");
        }
    }

    public void darDeAltaMoto( Moto motoPorInscribir ){
        if( listaDeVehiculosInscriptos.size() < cantidadVehiculosPermitidos ){
            listaDeVehiculosInscriptos.add(motoPorInscribir);
            System.out.println("Auto inscripto correctamente");
        }else{
            System.out.println("Cupo excedido");
        }
    }

    public void eliminarVehiculo( Vehiculo vehículoAEliminar){
        listaDeVehiculosInscriptos.remove(vehículoAEliminar);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        eliminarVehiculo(   listaDeVehiculosInscriptos
                            .stream()
                            .filter((Vehiculo x)->x.getPatente().equals(unaPatente))
                            .findFirst()
                            .get()
        );
    }

    public Vehiculo definirGanador(){
        double puntajeGanador = 0;
        Vehiculo vehiculoGanador = new Vehiculo();
        for(Vehiculo cadaVehiculo : listaDeVehiculosInscriptos){
            double puntajeDelVehiculo = calcularPuntajeDelVehiculo(cadaVehiculo);
            if( puntajeDelVehiculo > puntajeGanador){
                puntajeGanador = puntajeDelVehiculo;
                vehiculoGanador = cadaVehiculo;
            }
        }
        System.out.println("El puntaje ganador fue " + puntajeGanador);
        return vehiculoGanador;
    }

    private double calcularPuntajeDelVehiculo(Vehiculo cadaVehiculo){
        double velocidad = cadaVehiculo.getVelocidad();
        double aceleracion = cadaVehiculo.getVelocidad();
        double anguloDeGiro = cadaVehiculo.getAnguloDeGiro();
        double peso = cadaVehiculo.getPeso();
        short ruedas = cadaVehiculo.getRueda();

        return velocidad*(aceleracion/2)/(anguloDeGiro*(peso-(ruedas*100)));

    }

    public void iniciarCarrera() {
        System.out.println("Comienza la copa "+ nombre);
        System.out.println("Hay "+ listaDeVehiculosInscriptos.size() + " incriptos, pero solo uno sera el ganador ");
    }
}
