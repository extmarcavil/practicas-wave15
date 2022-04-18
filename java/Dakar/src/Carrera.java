import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Carrera {
    private double distancia;
    private int cantidadDeVehiculosPermitidos;
    private double premioEnDolares;
    private String nombre;
    private List <Vehiculo> vehiculoList;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, int cantidadDeVehiculosPermitidos, double premioEnDolares, String nombre) {
        this.distancia = distancia;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
        this.vehiculoList = new ArrayList<>();
    }

    public Carrera() {
    }

    public double getDistancia() {
        return distancia;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", vehiculoList=" + vehiculoList +
                '}';
    }
    public void darDeAltaAuto(int velocidad,int aceleracion, int anguloDeGiro, String patente){
        if( vehiculoList.size()<= cantidadDeVehiculosPermitidos ){
            System.out.println("Si hay cupos");
            Autos auto = new Autos(velocidad,aceleracion,anguloDeGiro,patente);
            boolean existe = vehiculoList.contains(auto);
            if (existe){
                System.out.println("El vehiculo se encuentra registrado");
            }else {
                vehiculoList.add(auto);
                System.out.println("Se ha registrado exitosamente el vehiculo con patente: " + patente);
            }

        }else {
            System.out.println("No hay cupos");
        }
    }
    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if( vehiculoList.size()<= cantidadDeVehiculosPermitidos ){
            System.out.println("Si hay cupos");
            Motos moto = new Motos(velocidad,aceleracion,anguloDeGiro,patente);
            boolean existe = vehiculoList.contains(moto);
            if (existe){
                System.out.println("El vehiculo se encuentra registrado");
            }else {
                vehiculoList.add(moto);
                System.out.println("Se ha registrado exitosamente el vehiculo");
            }

        }else {
            System.out.println("No hay cupos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculoList.contains(vehiculo)) {
            vehiculoList.remove(vehiculo);
            System.out.println("Vehiculo eliminado");
        }else{
            System.out.println("El vehiculo no existe");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){

        for (Vehiculo vehiculo : vehiculoList ){
            if (vehiculo.getPatente().equals(unaPatente)){
                System.out.println("Vehiculo con patente: " +unaPatente +" eliminada");
                vehiculoList.remove(vehiculo);
                break;
            }else {
                System.out.println("Vehiculo con la patente ingresada no se encuentra registrado");
            }
        }
    }

    public void ganadorCarrera(){
        if(vehiculoList.size()>0){
            Vehiculo vehGanador = vehiculoList.stream().max(Comparator.comparingDouble(Vehiculo::getPuntuacionCarrera)).get();
            System.out.println("El vehículo ganador tiene patente: " + vehGanador.getPatente());
        }
        else{
            System.out.println("Aún no hay inscriptos a la carrera");
        }
    }

    public void socorrerAuto(String patente){

        try{
            Autos autoASocorrer = (Autos)vehiculoList.stream().filter(v -> v.getPatente().equals(patente)).findFirst().get();
            socorristaAuto.socorrer(autoASocorrer);
        }
        catch (NoSuchElementException e){
            System.out.println("No existe tal auto con patente: " + patente);
        }
    }

    public void socorrerMoto(String patente){

        try{
            Motos motoASocorrer = (Motos)vehiculoList.stream().filter(v -> v.getPatente().equals(patente)).findFirst().get();
            socorristaMoto.socorrer(motoASocorrer);
        }
        catch (NoSuchElementException e){
            System.out.println("No existe tal moto con patente: " + patente);
        }
    }
}
