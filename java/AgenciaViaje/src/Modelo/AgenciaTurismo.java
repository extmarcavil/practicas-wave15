package Modelo;

import Repositorios.RepositorioCliente;
import Repositorios.RepositorioLocalizador;
import Repositorios.Servicio;

import java.util.ArrayList;

public class AgenciaTurismo {

    private RepositorioCliente clientes;
    private RepositorioLocalizador localizadores;

    public AgenciaTurismo(RepositorioCliente clientes, RepositorioLocalizador localizadores) {
        this.clientes = clientes;
        this.localizadores = localizadores;
    }

    private void agregarCliente(Cliente cliente){
        clientes.agregar(cliente);
    }

    private boolean descuentoPor2LocalizadoresPrevios(String dni, ArrayList<Localizador> listado_localizadores){
        int contador = 0;

        long localizadoresPrevios = listado_localizadores.stream().filter(c -> c.getCliente().getDni().equals(dni)).count();

        return  localizadoresPrevios >=2;
    }

    private boolean descuentoPaqueteCompleto(ArrayList<Servicio> servicios){
        boolean hotel = false, comida = false, boletos_viaje = false, transporte = false;

        for(Servicio serv : servicios) {
            if(serv.getNombre().equals("Hotel"))
                hotel = true;
            else if(serv.getNombre().equals("Comida"))
                comida = true;
            else if(serv.getNombre().equals("Boletos de viaje"))
                boletos_viaje = true;
            else
                transporte = true;

            if (hotel && comida && boletos_viaje && transporte)
                return true;
        }

        return false;
    }

    private boolean descuento2Hoteles2Boletos(ArrayList<Servicio> servicios){
        int hotel = 0, boleto = 0;

        for(Servicio serv : servicios) {
            if (serv.getNombre().equals("Hotel"))
                hotel++;
            else if (serv.getNombre().equals("Boletos de viaje"))
                boleto++;

            if (hotel == 2 || boleto == 2)
                return true;
        }

        return false;
    }

    public void agregarLocalizador (Cliente cliente, ArrayList<Servicio> listado_servicios){
        agregarCliente(cliente);
        double total = 0, descuento = 0;

        if (descuentoPor2LocalizadoresPrevios(cliente.getDni(),localizadores.getListado_localizadores()))
            descuento += 0.05;
        if (descuentoPaqueteCompleto(listado_servicios))
            descuento += 0.1;
        if (descuento2Hoteles2Boletos(listado_servicios))
            descuento += 0.05;

        for (Servicio servico : listado_servicios) {
            total += servico.getValor();
        }

        total = total - (total * descuento);
        Localizador localizador = new Localizador(cliente, listado_servicios, total);
        localizadores.agregar(localizador);
    }

    public RepositorioCliente getClientes() {
        return clientes;
    }

    public void setClientes(RepositorioCliente clientes) {
        this.clientes = clientes;
    }

    public RepositorioLocalizador getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(RepositorioLocalizador localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "AgenciaTurismo{" +
                "clientes=" + clientes +
                ", localizadores=" + localizadores +
                '}';
    }
}
