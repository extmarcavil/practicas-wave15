package ejercicioDakar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private double distancia;
    private int premioEnUsd;
    private String nombre;
    private int cantidadDeVehiculos;
    private HashSet<Vehiculo> listaVehiculos;
    private AutoSocorrista autoSocorrista;
    private MotoSocorrista motoSocorrista;


    public Carrera(double distancia, int premioEnUsd, String nombre, int cantidadDeVehiculos) {
        this.distancia = distancia;
        this.premioEnUsd = premioEnUsd;
        this.nombre = nombre;
        this.cantidadDeVehiculos = cantidadDeVehiculos;
        this.listaVehiculos = new HashSet<>();
        this.autoSocorrista = new AutoSocorrista();
        this.motoSocorrista = new MotoSocorrista();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (!(listaVehiculos.size() == cantidadDeVehiculos)) {
            if(listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente))) {
                System.out.println("Nuevo vehiculo agregado");
            } else {
                System.out.println("El vehiculo especificado ya se encuentra agregado ");
            }
        } else {
            System.out.println("No quedan lugares en la carrera para agregar mas vehiculos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (!(listaVehiculos.size() == cantidadDeVehiculos)) {
            if(listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente))) {
                System.out.println("Nuevo vehiculo agregado");
            } else {
                System.out.println("El vehiculo especificado ya se encuentra agregado ");
            }
        } else {
            System.out.println("No quedan lugares en la carrera para agregar mas vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        String patente = vehiculo.getPatente();
        this.eliminarVehiculoPorPatente(patente);
    }

    public void eliminarVehiculoPorPatente(String patente) {
        if(listaVehiculos.removeIf(v -> v.getPatente().equals(patente))) {
            System.out.println("Vehiculo removido");
        } else {
            System.out.println("La patente indicada no corresponde con ningun vehiculo");
        }
    }

    public void calcularGanador() {
        Vehiculo ganador = null;
        double resultado = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (resultado < vehiculo.calcularResultado()) {
                ganador = vehiculo;
                resultado = vehiculo.calcularResultado();
            }
        }
        System.out.println("El vehiculo ganador de la carrera con " + resultado + " puntos es: \n" + ganador.toString() + "");
    }

    public void socorrerAuto(String patente) {
        Vehiculo auto = listaVehiculos.stream()
                                        .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                                        .findFirst().orElse(null);
        if (auto != null) {
            this.autoSocorrista.socorrer((Auto) auto);
        } else {
            System.out.println("Patente ingresada no existente en la carrera");
        }
    }

    public void socorrerMoto(String patente) {
        Vehiculo moto = listaVehiculos.stream()
                                        .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                                        .findFirst().orElse(null);
        if (moto != null) {
            this.motoSocorrista.socorrer((Moto) moto);
        } else {
            System.out.println("Patente ingresada no existente en la carrera");
        }
    }
}
