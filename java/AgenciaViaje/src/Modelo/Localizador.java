package Modelo;

import Repositorios.Servicio;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Servicio> servicios;
    private double costo;

    public Localizador(Cliente cliente, List<Servicio> servicios, double costo) {
        this.cliente = cliente;
        this.servicios = servicios;
        this.costo = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", servicios=" + servicios +
                ", costo=" + costo +
                '}';
    }
}
