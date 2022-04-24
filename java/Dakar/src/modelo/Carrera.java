package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    public Double distancia;
    public Double premioEnDolares;
    public String nombre;
    public Integer cantVehiPermitidos;
    public List<Vehiculo> listaVehiculos;

    public Carrera() {
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantVehiPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiPermitidos = cantVehiPermitidos;
        this.listaVehiculos = listaVehiculos;
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
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiPermitidos=" + cantVehiPermitidos +
                ", listaVehiculos=" + listaVehiculos +
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
        if (cantRuedas == 2) {
            List<Vehiculo> m = listaVehiculos.stream()
                    .filter(vehiculo -> vehiculo instanceof Moto)
                    .collect(Collectors.toList());

            int indice = 0;
            Double velocidad = 0.0;
            for (int i = 0; m.size() > i; i++) {
                Vehiculo v = m.get(i);

                if (i == 0) {
                    velocidad = (v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloGiro() * (v.getPeso() - (v.getRuedas() * 100))));
                }

                Double velActual = (v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloGiro() * (v.getPeso() - (v.getRuedas() * 100))));
                if (velocidad < velActual && i != 0) {
                    velocidad = velActual;
                    indice = i;
                }

                return listaVehiculos.get(indice);
            }

            if (cantRuedas == 4) {
                List<Vehiculo> a = listaVehiculos.stream()
                        .filter(vehiculo -> vehiculo instanceof Auto)
                        .collect(Collectors.toList());

                int ind = 0;
                Double velo = 0.0;
                for (int i = 0; a.size() > i; i++) {
                    Vehiculo v = a.get(i);

                    if (i == 0) {
                        velo = (v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloGiro() * (v.getPeso() - (v.getRuedas() * 100))));
                    }

                    Double velActual = (v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloGiro() * (v.getPeso() - (v.getRuedas() * 100))));
                    if (velo < velActual && i != 0) {
                        velo = velActual;
                        ind = i;
                    }

                    return a.get(ind);
                }

            }
        }
        return null;
    }
}
