import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private  double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SoccorristaAuto soccorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.soccorristaAuto = new SoccorristaAuto();
        this.socorristaMoto = new SocorristaMoto();

    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloGiro, String patente){
        if(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Autos(velocidad, aceleracion, anguloGiro, patente));
        else
            System.out.println("Ya no se admiten más corredores en la carrera");
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloGiro, String patente){
        if(listaDeVehiculos.size()<= cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Motos(velocidad, aceleracion, anguloGiro, patente));
        else
            System.out.println("Ya no se admiten más corredores en la carrera");
    }

    public void eliminarVehiculo(Vehiculo vehiculoAEliminar){
        if(listaDeVehiculos.contains(vehiculoAEliminar))
            listaDeVehiculos.remove(vehiculoAEliminar);
        else
            System.out.println("El vehiculo no existe en la carrera");
    }

    public void eliminarVehiculoConPatente(String patente){
        Boolean existe = false;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                listaDeVehiculos.remove(vehiculo);
                existe = true;
                break;
            }
        }
        if (!existe)
            System.out.println("El vehiculo no existe en la carrera");
    }

    public Vehiculo vehiculoGanador(){
        Vehiculo vehiculoGanador = null;
        double maximoValor = 0;
        double distaciaRecorriaPorAuto=0;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            distaciaRecorriaPorAuto = (vehiculo.getVelocidad()*(1/2)*vehiculo.getAceleracion())/(vehiculo.getAnguloGiro()*(vehiculo.getPeso()-(vehiculo.getRuedas()*100)));
            if(distaciaRecorriaPorAuto>maximoValor){
                vehiculoGanador = vehiculo;
                maximoValor = distaciaRecorriaPorAuto;
            }
        }
        return  vehiculoGanador;
    }

    public Vehiculo buscarVehiculoConPatente(String patente){
        Boolean existe = false;
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculoEncontrado = vehiculo;
                existe = true;
                break;
            }
        }
        if (existe== false) {
            System.out.println("El vehiculo no existe en la carrera");
        }
        return vehiculoEncontrado;
    }

    public void socorrerAuto(String patente){
        if(buscarVehiculoConPatente (patente) instanceof Autos)
            soccorristaAuto.socorrer((Autos) buscarVehiculoConPatente(patente));
        else
            System.out.println("El vehiculo no es de tipo Auto");
    }

    public void socorrerMoto(String patente){
        if(buscarVehiculoConPatente(patente)instanceof Motos)
            socorristaMoto.socorrer((Motos) buscarVehiculoConPatente(patente));
        else
            System.out.println("El vehiculo no es de tipo Moto");
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }
}
