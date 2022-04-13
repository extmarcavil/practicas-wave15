import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        listaDeVehiculos = new ArrayList<Vehiculo>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            if(buscarVahiculo(patente) == -1)
            {
                listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Alta de Auto exitosa - Patente: " + patente);
            }else
            {
                System.out.println("El auto ya está registrado");
            }

        } else {
            System.out.println("No hay más cupo");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            if(buscarVahiculo(patente) == -1)
            {
                listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Alta de Moto exitosa - Patente: " + patente);
            }else
            {
                System.out.println("El auto ya está registrado");
            }
        } else {
            System.out.println("No hay más cupo");
        }
    }

    public int buscarVahiculo(String patente){
        return IntStream.range(0, listaDeVehiculos.size())
                .filter(i -> listaDeVehiculos.get(i).getPatente().equals(patente))
                .findFirst()
                .orElse(-1);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        String patente = vehiculo.getPatente();
        if (listaDeVehiculos.remove(vehiculo)){
            System.out.println("El vehículo se ha eliminado de la carrera - Patente: " + patente);
        } else {
            System.out.println("El vehículo no es parte de esta carrera");
        }

    }

    public void eliminarVehiculoConPatente(String patente){
        int index = buscarVahiculo(patente);
        if (index != -1) {
            eliminarVehiculo(listaDeVehiculos.get(index));
        } else {
            System.out.println("El vehículo no es parte de esta carrera - Patente: " + patente);
        }
    }

    public void ganador(){
        ArrayList<Vehiculo> ganadores =  listaDeVehiculos.stream().filter(
                vehiculo ->
                        vehiculo.valorDeCarrera()==(
                                listaDeVehiculos.stream()
                                        .mapToDouble(Vehiculo::valorDeCarrera)
                                        .max()
                                        .getAsDouble()
                        )
        ).collect(Collectors.toCollection(ArrayList::new));
        if(ganadores.size()>1){
            System.out.println("Los ganadres son: ");
            ganadores.forEach(System.out::println);
        } else {
            System.out.println("El ganador es: ");
            ganadores.forEach(System.out::println);
        }
    }

    public void socorrerAuto(String patente){
        int index = buscarVahiculo(patente);
        if(index!=-1){
            Vehiculo vehiculo = listaDeVehiculos.get(index);
            if(vehiculo instanceof Auto){
                socorristaAuto.socorrer((Auto)vehiculo);
            }
            else{
                System.out.println("No puede socorrer a una Moto");
            }
        } else{
            System.out.println("El vehículo no es parte de esta carrera - Patente: " + patente);
        }
    }

    public void socorrerMoto(String patente){
        int index = buscarVahiculo(patente);
        if(index!=-1){
            Vehiculo vehiculo = listaDeVehiculos.get(index);
            if(vehiculo instanceof Moto){
                socorristaMoto.socorrer((Moto)vehiculo);
            }
            else{
                System.out.println("No puede socorrer a una Moto");
            }
        } else{
            System.out.println("El vehículo no es parte de esta carrera - Patente: " + patente);
        }
    }

}
