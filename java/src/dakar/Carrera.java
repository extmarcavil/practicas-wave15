package dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();

    SocorristaAuto socorristaAuto = new SocorristaAuto();
    SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
        if(cantidadVehiculosPermitidos > listaDeVehiculos.size())
            listaDeVehiculos.add(auto);
        else
            System.out.println("Sin cupo para el auto con patente " + patente);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if(cantidadVehiculosPermitidos > listaDeVehiculos.size())
            listaDeVehiculos.add(moto);
        else
            System.out.println("Sin cupo para la moto con patente " + patente);

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaDeVehiculos.contains(vehiculo))
            listaDeVehiculos.remove(vehiculo);
        else
            System.out.println("Vehiculo no encontrado.");
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo v = buscarVehiculoPorPatente(unaPatente);
        eliminarVehiculo(v);
    }

    public Vehiculo buscarVehiculoPorPatente(String patente){

        Vehiculo buscado = listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst().orElse(null);

        return buscado;

    }

    public Vehiculo obtenerGanador(){
        Vehiculo vAux = null;
        double aux = 0;
        double valorObtenido;
        for(Vehiculo v: listaDeVehiculos){
            valorObtenido = v.obtenerValorCarrera();
            if(aux < v.obtenerValorCarrera()) {
                aux = valorObtenido;
                vAux = v;
            }
        }
        return vAux;
    }

    public void socorrerAuto(String patente){
        Vehiculo v = buscarVehiculoPorPatente(patente);
        socorristaAuto.socorrer((Auto) v);
    }

    public void socorrerMoto(String patente){
        Vehiculo v = buscarVehiculoPorPatente(patente);
        socorristaMoto.socorrer((Moto) v);
    }

    public void mostrarVehiculos(){
        for(Vehiculo i: listaDeVehiculos)
            System.out.println(i);
    }

}
