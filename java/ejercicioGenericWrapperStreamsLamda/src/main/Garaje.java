package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;

public class Garaje {

    private int id;
    private List<Vehiculo> listaVehiculos;

    public Garaje(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public Garaje(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Vehiculo> getVehiculos(){ ;
        return listaVehiculos;
    }

    @Override
    public String toString() {
        return "Garaje ID: " + id +
                "Vehículos: " + listaVehiculos;
    }

    public void getVehiculosPorPrecioMenorAMayor() {
        List<Vehiculo> vehiculo = getVehiculos();
        vehiculo.stream()
                .sorted((a,b) -> a.getCosto().compareTo(b.getCosto()))
                .forEach(System.out::println);
    }

    public void getVehiculosPorMarcayPrecioMenorAMayor() {
        Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        List<Vehiculo> vehiculo = getVehiculos();
        vehiculo.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public void getVehiculosMenor1000(){
        List<Vehiculo> vehiculo = getVehiculos();
        vehiculo.stream()
                .filter(a -> a.getCosto() < 1000)
                .forEach(System.out::println);
    }

    public void getVehiculos1000oMas(){
        List<Vehiculo> vehiculo = getVehiculos();
        vehiculo.stream()
                .filter(a -> a.getCosto() >= 1000)
                .forEach(System.out::println);
    }

    public Double getPromedioCosto() {
        List<Vehiculo> vehiculo = getVehiculos();
        return vehiculo.stream()
                    .collect(averagingDouble(x -> x.getCosto()));
    }

}
