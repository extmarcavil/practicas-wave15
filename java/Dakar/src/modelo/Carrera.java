package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantVehiPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantVehiPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiPermitidos = cantVehiPermitidos;
        this.listaVehiculos = new ArrayList<>();
        //No ingreso datos a la lista de vehiculos porque debemos validar el cupo y
        // no se si es buena practica hacer validaciones de reglas de negocio en un constructor
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantVehiPermitidos() {
        return cantVehiPermitidos;
    }

    public void setCantVehiPermitidos(Integer cantVehiPermitidos) {
        this.cantVehiPermitidos = cantVehiPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        if(listaVehiculos.size() > cantVehiPermitidos){
            System.out.println("La cantidad de vehiculos a inscribir supera el cupo permitido");
        } else {
            this.listaVehiculos = listaVehiculos;
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiPermitidos=" + cantVehiPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {

        Vehiculo v = new Auto(velocidad, aceleracion, anguloGiro, patente);
        if (cantVehiPermitidos > listaVehiculos.size()) {
            listaVehiculos.add(v);
        } else {
            System.out.println("No hay cupos disponibles");
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {

        Vehiculo v = new Moto(velocidad, aceleracion, anguloGiro, patente);
        if (cantVehiPermitidos > listaVehiculos.size()) {
            listaVehiculos.add(v);
        } else {
            System.out.println("No hay cupos disponibles");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.remove(vehiculo)) {
            System.out.println("Se elimino el vehiculo" + vehiculo);
            System.out.println("Lista de vehiculos" + listaVehiculos);
        } else {
            System.out.println("El vehivulo no se encuentra");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Optional<Vehiculo> v = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente))
                .findFirst();
        if (v.isPresent()) {
            eliminarVehiculo(v.get());
        } else {
            System.out.println("No existe vehiculo con patente " + unaPatente);
        }
    }

    public Vehiculo ganador(Integer cantRuedas) {
        double velocidadMax = 0.0;
        if (cantRuedas == 2) {
            List<Vehiculo> motos = listaVehiculos.stream()
                    .filter(vehiculo -> vehiculo instanceof Moto)
                    .collect(Collectors.toList());
            Vehiculo motoGanadora = null;
            for (Vehiculo moto : motos) {
                double velActual = (moto.getVelocidad() * 0.5 * moto.getAceleracion() / (moto.getAnguloGiro() * (moto.getPeso() - (moto.getRuedas() * 100))));
                if (velocidadMax < velActual) {
                    motoGanadora = moto;
                    velocidadMax = velActual;
                }
            }
            return motoGanadora;
        }
        else{
            if (cantRuedas == 4) {
                List<Vehiculo> autos = listaVehiculos.stream()
                        .filter(vehiculo -> vehiculo instanceof Auto)
                        .collect(Collectors.toList());
                Vehiculo autoGanador = null;
                for (Vehiculo auto: autos) {
                    double velActual = (auto.getVelocidad() * 0.5 * auto.getAceleracion() / (auto.getAnguloGiro() * (auto.getPeso() - (auto.getRuedas() * 100))));
                    if (velocidadMax < velActual) {
                        velocidadMax = velActual;
                        autoGanador = auto;
                    }
                }
                return autoGanador;
            }
        }
        return null;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> auto = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente) && v instanceof Auto).findFirst();
        if(auto.isPresent()){
            socorristaAuto.socorre((Auto)auto.get());
        } else {
            System.out.println("No existe auto con patente: " + patente);
        }
    }
    public void socorrerMoto(String patente){
        Optional<Vehiculo> moto = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente) && v instanceof Moto).findFirst();
        if(moto.isPresent()){
            socorristaMoto.socorre((Moto)moto.get());
        } else {
            System.out.println("No existe moto con patente: " + patente);
        }
    }
}
