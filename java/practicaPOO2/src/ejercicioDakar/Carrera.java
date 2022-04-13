package ejercicioDakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente)
    {
        if (listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
            System.out.println("El auto fue agregado a la carrera!");
        }
        else{
            System.out.println("No hay cupo para agregar auto!");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente){

        if (listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Moto moto  = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
            System.out.println("La moto fue agregada a la carrera!");
        }
        else
        {
            System.out.println("No hay cupo para agregar moto!");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (!listaVehiculos.removeIf(p -> vehiculo.getPatente().equals(p.getPatente()))) {
            System.out.println("No existe la patente a eliminar");
        } else {
            System.out.println("Vehiculo eliminado.");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        if (!listaVehiculos.removeIf(p -> patente.equals(p.getPatente()))) {
            System.out.println("No existe la patente a eliminar");
        } else {
            System.out.println("Vehiculo eliminado por patente.");
        }
    }

    public void ganadorCarrera(){
        double mayor=0;
        Vehiculo vehiculoGanador= new Vehiculo();

        for (Vehiculo vehiculo : listaVehiculos) {
            double calculo= ((vehiculo.getVelocidad() * (vehiculo.getAceleracion()/2)) / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-(vehiculo.getRuedas()*100))));
            if(mayor < calculo) {
                mayor = calculo;
                vehiculoGanador = vehiculo;
            }
        }
        System.out.println("Vehiculo ganador:");
        System.out.println(vehiculoGanador.toString());

    }

    public void socorrerAuto(String patente) {

        Vehiculo v = listaVehiculos.stream()
                .filter(p -> patente.equals(p.getPatente()))
                .findAny()
                .orElse(null);
        if (v != null){
            if (v.getClass().isInstance(Auto.class)) {
                socorristaAuto.socorrer(((Auto) v));
            }
            else{
                System.out.println( "La patente no corresponde a un Auto.");
            }
        }else {
            System.out.println("El vehiculo con la patente: " + v.getPatente() + " no existe.");
        }

        }

        public void socorrerMoto (String patente){

            Vehiculo v = listaVehiculos.stream()
                    .filter(p -> patente.equals(p.getPatente()))
                    .findAny()
                    .orElse(null);
            if (v != null){
                if (v.getClass().isInstance(Moto.class)) {
                    socorristaMoto.socorrer(((Moto) v));
                }
                else{
                    System.out.println( "La patente no corresponde a una Moto.");
                }
            }else {
                System.out.println("El vehiculo con la patente: " + v.getPatente() + " no existe.");
            }

        }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }
}

