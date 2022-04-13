import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantVehiculos;
    private ArrayList<Vehiculo> listaVehiculos;
    private SocorrerAuto socorristaAuto;
    private SocorrerMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculos = cantVehiculos;
        this.listaVehiculos = new ArrayList<>(cantVehiculos);
        this.socorristaAuto = new SocorrerAuto();
        this.socorristaMoto = new SocorrerMoto();
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

    public int getCantVehiculos() {
        return cantVehiculos;
    }

    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculos=" + cantVehiculos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size()<cantVehiculos){
            listaVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        } else {
            System.out.println("Maxima cantidad alcanzada :(");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size()<cantVehiculos){
            listaVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        } else {
            System.out.println("Maxima cantidad alcanzada :(");
        }
    }

    private void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.contains(vehiculo)){
            listaVehiculos.remove(vehiculo);
        } else {
            System.out.println("Ese vehiculo no está en la lista");
        }
    }

    public void eliminarVehiculoPorPatente(String patente){
        Vehiculo vehiculoAEliminar = listaVehiculos.stream()
                .filter(v->v.getPatente().equals(patente))
                .findFirst().get();

        eliminarVehiculo(vehiculoAEliminar);
    }

    public void definirGanador(){
        Vehiculo vehiculoGanador = listaVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getValorDeCarrera))
                .get();
        System.out.println("El vehículo ganador es: " + vehiculoGanador);
    }

    public void socorrerAuto(String patente){
        Auto vehiculoASocorrer = (Auto)listaVehiculos.stream()
                .filter(v->v.getPatente().equals(patente))
                .findFirst().get();
        if(vehiculoASocorrer != null){
            socorristaAuto.socorrer(vehiculoASocorrer);
        } else{
            System.out.println("No hay un auto con esa patente");
        }
    }

    public void socorrerMoto(String patente){
        Moto vehiculoASocorrer = (Moto)listaVehiculos.stream()
                .filter(v->v.getPatente().equals(patente))
                .findFirst().get();
        if(vehiculoASocorrer != null){
            socorristaMoto.socorrer(vehiculoASocorrer);
        } else{
            System.out.println("No hay una moto con esa patente");
        }
    }
}
