package Dakar;

import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    SocorristaAuto socorristaAuto = new SocorristaAuto();
    SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if (listaVehiculos.size() < cantidadVehiculosPermitidos){
            Auto auto1 = new Auto(velocidad,aceleracion,anguloGiro, patente,1000,4);
            listaVehiculos.add(auto1);
        }
        else{
            System.out.println("No queda mas lugar en esta carrera para este auto");
        }
    }


    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if (listaVehiculos.size() < cantidadVehiculosPermitidos){
            Moto moto1 = new Moto(velocidad,aceleracion,anguloGiro, patente,300,2);
            listaVehiculos.add(moto1);
        }
        else{
            System.out.println("No queda mas lugar en esta carrera para esta moto");
        }
    }


    public void eliminarVehiculo(Vehiculo vehiculo){

    }

    public void eliminarVehiculoConPatente(String patente){
        for (Vehiculo v : listaVehiculos){
            if (v.getPatente().equals(patente)){
                listaVehiculos.remove(v);
            }
        }
    }

    public Vehiculo buscarVehiculoXPatente(String patente){
        Optional<Vehiculo> vehiculo = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
        if(vehiculo.isEmpty())
            System.out.println("No se encontro el vehiculo con la patente: " + patente);

        return vehiculo.get();
    }


    public String vehiculoGanador(){
        String patenteGanadora = "";
        double resultadoMax = 0;
        for (Vehiculo c : listaVehiculos){
            var resultado = c.getVelocidad() * 1/2 * c.getAceleracion() / (c.getAnguloGiro()*(c.getPeso()- c.getRuedas() * 100));
            if(resultado > resultadoMax){
                resultadoMax = resultado;
                patenteGanadora = c.getPatente();
            }
        }
        return patenteGanadora;
    }


    public void socorrerAuto(String patente){
        try {
            socorristaAuto.socorrer((Auto) buscarVehiculoXPatente(patente));
        }
        catch (Exception ex){
        }
    }

    public void socorrerMoto(String patente){
        try {
            socorristaMoto.socorrer((Moto) buscarVehiculoXPatente(patente));
        }
        catch (Exception ex){
        }
    }


}
