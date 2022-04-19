package com.company;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioUsd;
    private String nombre;
    private int cantDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos=new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
    }

    public Carrera(double distancia, double premioUsd, String nombre, int cantDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioUsd = premioUsd;
        this.nombre = nombre;
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
    }

    public Carrera(double distancia, double premioUsd, String nombre, int cantDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioUsd = premioUsd;
        this.nombre = nombre;
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioUsd() {
        return premioUsd;
    }

    public void setPremioUsd(double premioUsd) {
        this.premioUsd = premioUsd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDeVehiculosPermitidos() {
        return cantDeVehiculosPermitidos;
    }

    public void setCantDeVehiculosPermitidos(int cantDeVehiculosPermitidos) {
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
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
                ", premioUsd=" + premioUsd +
                ", nombre='" + nombre + '\'' +
                ", cantDeVehiculosPermitidos=" + cantDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, int rueda, double peso) {
        // Validarmos que haya cupos libres en la carrera
        if (listaDeVehiculos.size() < cantDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente, rueda, peso);
            //Verificamos que el auto ya no este registrado
            boolean existe = listaDeVehiculos.contains(auto);
            if (existe){
                System.out.println("El auto ya se encuentra registrado");
            }else {
                listaDeVehiculos.add(auto);
                System.out.println("El auto se ha registrado exitosamente");
            }
        }else {
            System.out.println("No hay cupos para dicha carrera");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, int rueda, double peso) {
        // Validarmos que haya cupos libres en la carrera
        if (listaDeVehiculos.size() < cantDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente, rueda, peso);
            boolean existe = listaDeVehiculos.contains(moto);
            if (existe){
                System.out.println("La moto ya se encuentra registrado");
            }else {
                listaDeVehiculos.add(moto);
                System.out.println("La moto se ha registrado exitosamente");
            }
        }else {
            System.out.println("No hay cupos para dicha carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        //System.out.println(vehiculo.getPatente());
        listaDeVehiculos.remove(vehiculo);
        if (vehiculo instanceof Auto) {
            System.out.println("El auto se eliminó correctamente");
        } else if (vehiculo instanceof Moto) {
            System.out.println("La moto se eliminó correctamente");
        } else {
            System.out.println("El vehículo no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        boolean encontre = false;
        Vehiculo v=null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                encontre = true;
              v=vehiculo;
            }
        }
        if (!encontre) {
            System.out.println("El vehículo solicitado para eliminar no se encuentra inscripto.");
        }else{
           eliminarVehiculo(v);
        }
    }

    public Vehiculo vehiculoGanador (List<Vehiculo> listaDeVehiculos){
        double formula = 0;
        double numeroGanador = 0;
        Vehiculo v2 = null;
        String aux;
        for (Vehiculo v : listaDeVehiculos) {
            formula = ((v.getVelocidad()*1/2*v.getAceleracion())/(v.getAngDeGiro()*(v.getPeso()-(v.getRueda()*100))));
            if (formula > numeroGanador){
                numeroGanador = formula;
                v2 = v;
            }
        }
        if (v2.getRueda() == 2) {
            System.out.println("El vehiculo ganador es la moto:");
        } else if (v2.getRueda() == 4) {
            System.out.println("El vehiculo ganador es el auto:");
        }
        System.out.println("Vehiculo{" +
                "velocidad=" + v2.getVelocidad() +
                ", aceleracion=" + v2.getAceleracion() +
                ", angDeGiro=" + v2.getAngDeGiro() +
                ", patente='" + v2.getPatente() + '\'' +
                ", rueda=" + v2.getRueda() +
                ", peso=" + v2.getPeso() +
                '}');
        return v2;
    }
    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            //busco dentro de la lista de vehiculos el auto a socorrer
            if (vehiculo.getPatente().equals(patente) ) {
                if (vehiculo instanceof Auto) {
                    autoASocorrer = (Auto) vehiculo;
                }
            }
        }
        //si encontre el auto que voy a socorrer entro, sino informo que no existe dicho auto
        if (autoASocorrer != null) {
            SocorristaAuto sa = new SocorristaAuto();
            sa.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente especificada para ser socorrido.");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            //busco dentro de la lista de vehiculos la moto a socorrer
            if (vehiculo.getPatente().equals(patente)) {
                if (vehiculo instanceof Moto) {
                    motoASocorrer = (Moto) vehiculo;
                }
            }
        }
        //si encontre la moto que voy a socorrer entro, sino informo que no existe dicha moto
        if (motoASocorrer != null) {
            SocorristaMoto sm = new SocorristaMoto();
            sm.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente especificada para ser socorrido.");
        }
    }
}
