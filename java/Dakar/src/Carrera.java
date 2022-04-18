import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(double distancia, double premioDolares, String nombre, int cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
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

    public List<Vehiculo> getVehiculosPermitidos() {
        return listaVehiculos;
    }

    public void setVehiculosPermitidos(List<Vehiculo> vehiculosPermitidos) {
        this.listaVehiculos = vehiculosPermitidos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculosPermitidos=" + cantVehiculosPermitidos +
                ", vehiculosPermitidos=" + listaVehiculos +
                '}';
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(cantVehiculosPermitidos > listaVehiculos.size()){
           Auto auto = new Auto(velocidad, aceleracion, anguloGiro, patente);
           listaVehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(cantVehiculosPermitidos > listaVehiculos.size()){
           Motocicleta moto = new Motocicleta(velocidad, aceleracion, anguloGiro, patente);
           listaVehiculos.add(moto);
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.contains(vehiculo)){
           listaVehiculos.remove(vehiculo);
        }else{
            System.out.println("El vehiculo no se encuentra en la lista");
        }
    }
    public void eliminarVehiculoConPatente(String patente){
        Vehiculo ve = null;
        for(Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                ve = vehiculo;
            }
        }
        if(ve != null)
           listaVehiculos.remove(ve);
    }
    public void definirGanador(){
        double resultadoMaximo = 0;
        double resultadoParcial = 0;
        Vehiculo vehiculoGanador = null;
        for(Vehiculo vehiculo : listaVehiculos){
            resultadoParcial = ((vehiculo.getVelocidad() *(vehiculo.getAceleracion()/2))
                               /(vehiculo.getAnguloGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)));
            if(resultadoParcial > resultadoMaximo){
               resultadoMaximo = resultadoParcial;
               vehiculoGanador = vehiculo;
            }
        }
        System.out.println("El vehiculo ganador es " + vehiculoGanador.toString());
    }

    public void socorrerAuto(String patente){
        Socorrista socorrista = new Socorrista();
        for(Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorrista.socorrer((Auto) vehiculo);
            }
        }
    }
    public void socorrerMoto(String patente){
        Socorrista socorrista = new Socorrista();
        for(Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                socorrista.socorrer((Motocicleta) vehiculo);
            }
        }
    }
}
