import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculos;
    private List<Vehiculo> vehiculos= new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadVehiculos,SocorristaMoto socorristaMoto,SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculos = cantidadVehiculos;
        this.socorristaAuto=socorristaAuto;
        this.socorristaMoto=socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(vehiculos.size()>=cantidadVehiculos) {
            System.out.println("No hay espacio para mas vehiculos :(");
            return;
        }

        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(vehiculos.size()>=cantidadVehiculos){
            System.out.println("No hay espacio para mas vehiculos :(");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        vehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculos.contains(vehiculo)){
            vehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado ");

        }

    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculo=vehiculos.stream()
                .filter(v -> v.getPatente().equalsIgnoreCase(unaPatente))
                .findFirst()
                .orElse( null);


        if(vehiculo!=null){
            vehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado");
        }
    }

    public Vehiculo ganador(){
        double max=-214748364;
        Vehiculo ganador=null;

        for(int i=0;i<vehiculos.size();i++){
            Vehiculo v= vehiculos.get(i);
            double vel= v.getVelocidad()*(v.getAceleracion()/2)/(v.getAnguloDeGiro()*(v.getPeso()-(v.getRuedas()*100)));
            if(vel>max){
                max=vel;
                ganador=v;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo=vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse( null);


        if(vehiculo==null){
            System.out.println("No se encontro Auto para socorrer con la petente: " + patente);
            return;
        }

        socorristaAuto.socorrer(vehiculo);
        System.out.println("Auto socorrido");
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo=vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse( null);


        if(vehiculo==null){
            System.out.println("No se encontro Moto para socorrer con la petente: " + patente);
            return;
        }

        socorristaMoto.socorrer(vehiculo);
        System.out.println("Moto socorrida");
    }
}
