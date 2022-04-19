package EjercicioIntegrador.EjercicioDakar;

import java.util.List;

public class Carrera {
    private double distancia;
    private int cantidadDeVehiculosPermitidos;
    private double premioEnDolares;
    private String nombre;
    private List <Vehiculo> vehiculoList;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, int cantidadDeVehiculosPermitidos, double premioEnDolares, String nombre, List<Vehiculo> vehiculoList, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.vehiculoList = vehiculoList;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
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

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", vehiculoList=" + vehiculoList +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
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
                    System.out.println("Se ha registrado exitosamente el vehiculo");
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
            }else {
                System.out.println("Vehiculo con la patente ingresada no se encuentra registrado");
            }
        }
    }
}
