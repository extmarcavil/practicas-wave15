package IntegradoresP2.Dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera<T extends Vehiculo> {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<T> vehiculos = new ArrayList<>();
    private Socorrista<T> socorrista = new Socorrista();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<T> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<T> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaVehiculo(T vehiculo){
        // Agregar un vehículo a la carrera.
        if (vehiculos.size() < cantidadVehiculosPermitidos){
            vehiculos.add(vehiculo);
            System.out.println("+ Vehículo agregado. " + vehiculo);
        } else {
            System.out.println("Cupos completos. No se pudo agregar al vehículo.");
        }
    }

    public void eliminarVehiculo(T vehiculo){
        // Eliminar un vehículo.
        vehiculos.remove(vehiculo);
        System.out.println("- Vehículo con patente " + vehiculo.getPatente() + " eliminado.");
    }

    public void eliminarVehiculoConPatente(String patente){
        // Eliminar un vehículo a partir de su patente.
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresentOrElse(v -> {
                    vehiculos.remove(v);
                    System.out.println("- Vehículo con patente " + patente + " eliminado.");
                }, () -> System.out.println("Vehiculo no encontrado."));
    }

    public Vehiculo determinarGanador(){
        // Determinar el ganador de la carrera.
        Vehiculo ganador = vehiculos.stream().max(Comparator.comparing(Vehiculo::getMax)).get();
        System.out.println("El ganador es el vehículo con patente " + ganador.getPatente());
        return ganador;
    }

    public void socorrer(String patente){
        // Socorrer a un vehiculo.
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresentOrElse(v -> socorrista.socorrer(v), () -> System.out.println("Vehiculo no encontrado."));
    }
}
