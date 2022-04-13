package ejercicioDakar;

import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> lstVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantVehiculosPermitidos, List<Vehiculo> lstVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.lstVehiculos = lstVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (lstVehiculos.size() < this.cantVehiculosPermitidos) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            lstVehiculos.add(auto);
        } else {
            System.out.println("No hay cupo para agregar auto!");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (lstVehiculos.size() < this.cantVehiculosPermitidos) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            lstVehiculos.add(moto);
        } else {
            System.out.println("No hay cupo para agregar moto!");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        this.lstVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.lstVehiculos.removeIf(v -> )
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

    public int getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(int cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public List<Vehiculo> getLstVehiculos() {
        return lstVehiculos;
    }

    public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
        this.lstVehiculos = lstVehiculos;
    }
}
