package dakar;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantVehiculosPermitidos;
    private Set<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        vehiculos=new HashSet<>(cantVehiculosPermitidos);
        this.socorristaAuto=socorristaAuto;
        this.socorristaMoto=socorristaMoto;
    }

    public void darDeAltaAuto(Integer velocidad,Double aceleracion,Double anguloDeGiro,String patente){
        if (vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente))) System.out.println("Auto dado de alta con exito");
            else System.out.println("No pudo darse de alta");
    }

    public void darDeAltaMoto(Integer velocidad,Double aceleracion,Double anguloDeGiro,String patente){
        if(vehiculos.size()<cantVehiculosPermitidos){
            if (vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente)))
                System.out.println("Auto dado de alta con exito");
            else System.out.println("No pudo darse de Alta");
        }
        else System.out.println("La cantidad de vehiculos fue alcanzada :(");
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        vehiculos.remove(vehículo);
    }

    private Vehiculo buscador(String patente){
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente()==patente)
                .findFirst()
                .orElse(null);
    }


    public void eliminarVehiculoConPatente(String unaPatente){
        if (vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente)))
            System.out.println("Se borro el vehiculo con la patente "+unaPatente);
        else
            System.out.println("No existe ningun vehiculo con la patente "+unaPatente);

    }

    private Double getScore(Vehiculo vehiculo){
        return  .5*vehiculo.getVelocidad()*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getCantRuedas()*100));
    }

    public Vehiculo ganador(){
        return vehiculos.stream()
                .sorted(Comparator.comparing(this::getScore).reversed())
                .findFirst()
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        Vehiculo v= buscador(patente);
        if( v instanceof Auto )
            socorristaAuto.socorrer((Auto) v);
        else
            System.out.println("No puedo socorrer a la patente "+ patente);
    }

    public void socorrerMoto(String patente){
        Vehiculo v= buscador(patente);
        if( v instanceof Moto )
            socorristaMoto.socorrer((Moto) v);
        else
            System.out.println("No puedo socorrer a la patente "+ patente);
    }
}
