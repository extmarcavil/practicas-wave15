import vehiculo.Auto;
import vehiculo.Moto;
import vehiculo.Vehiculo;
import vehiculo.socorrista.SocorristaAuto;
import vehiculo.socorrista.SocorristaMoto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        listaVehiculos = new ArrayList<>();

        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        if(cuposDisponibles()) {
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
        } else
            System.out.println("No hay cupos disponibles para inscribir al auto");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        if(cuposDisponibles()) {
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
        } else
            System.out.println("No hay cupos disponibles para inscribir a la moto");
    }

    private boolean cuposDisponibles() {
        return listaVehiculos.size() < cantidadVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        listaVehiculos.remove(buscarVehiculo(patente));
    }

    private Vehiculo buscarVehiculo(String patente) {
        Optional<Vehiculo> vehiculo = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();

        if(vehiculo.isEmpty())
            System.out.println("No se encontro al vehiculo con la patente: " + patente);

        return vehiculo.get();
    }

    public Vehiculo calcularGanador() {
        return listaVehiculos.stream().max(Comparator.comparing(Vehiculo::obtenerValorCompeticion)).get();
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer((Auto) buscarVehiculo(patente));
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer((Moto) buscarVehiculo(patente));
    }
}
