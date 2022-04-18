import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){

        if(cantidadDeVehiculosPermitidos == listaDeVehiculos.size())
        {
            System.out.println("No hay cupo.");
            return;
        }

        listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){

        if(cantidadDeVehiculosPermitidos == listaDeVehiculos.size())
        {
            System.out.println("No hay cupo.");
            return;
        }

        listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        listaDeVehiculos.removeIf(v -> v.getPatente().equals(patente));
    }

    public void imprimirVehiculos(){
        System.out.println("Lista de vehiculos:");
        for (Vehiculo vehiculo : listaDeVehiculos)
            System.out.println(vehiculo.toString());
    }

    public void imprimirGanador(){
        listaDeVehiculos.sort((v1, v2) -> {
            if (v1.getValorPuntaje() < v2.getValorPuntaje()) return 1;
            if (v1.getValorPuntaje() > v2.getValorPuntaje()) return -1;
            return 0;
        });

        System.out.println(listaDeVehiculos.get(0));
    }

    public void socorrerAuto(String patente){
        SocorristaAuto socorrista = new SocorristaAuto();
        Optional<Vehiculo> result = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
        if (result.isPresent()) {
            Vehiculo vehiculo = result.get();
            socorrista.socorrer((Auto) vehiculo);
        } else{
            System.out.println("No existe auto con esta patente");
        }

    };
    public void socorrerMoto(String patente){
        SocorristaMoto socorrista = new SocorristaMoto();
        Optional<Vehiculo> result = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
        if (result.isPresent()) {
            Vehiculo vehiculo = result.get();
            socorrista.socorrer((Moto) vehiculo);
        } else{
            System.out.println("No existe moto con esta patente");
        }
    };

}
