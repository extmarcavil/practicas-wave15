package com.company.repository;

import com.company.model.*;

import java.util.*;

public class Repositorio implements LocalizadorQuery{

    private List<Localizador> localizadores;

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(ArrayList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador (Localizador local){
        final double descuento2Localizadores = 0.05, descuentoPaqueteCompleto = 0.1, descuentoReservaOBoleto = 0.05;

        boolean aplicarDescuento2Localizadores = localizadores.stream().filter(l -> l.getCliente().getDni().equals(local.getCliente().getDni())).count() >= 2;
        boolean aplicarDescuentoPaqueteCompleto = local.getPaquete().getBoleto().size() > 0
                                                    && local.getPaquete().getComida().size() > 0
                                                    && local.getPaquete().getReserva().size() > 0
                                                    && local.getPaquete().getTransporte() != null;
        boolean aplicarDescuentoReservaOBoleto = local.getPaquete().getBoleto().size() >= 2 || local.getPaquete().getReserva().size() >= 2;

        double precio = local.getPaquete().getBoleto().stream().mapToDouble(Boleto::getPrecio).sum()
                        + local.getPaquete().getComida().stream().mapToDouble(Comida::getPrecio).sum()
                        + local.getPaquete().getReserva().stream().mapToDouble(ReservaHotel::getPrecio).sum();

        if(local.getPaquete().getTransporte() != null){
            precio += local.getPaquete().getTransporte().getPrecio();
        }

        float descuentoTotal = 0;
        if(aplicarDescuento2Localizadores){
            descuentoTotal += descuento2Localizadores;
        }
        if(aplicarDescuentoPaqueteCompleto){
            descuentoTotal += descuentoPaqueteCompleto;
        }
        if(aplicarDescuentoReservaOBoleto){
            descuentoTotal += descuentoReservaOBoleto;
        }
        precio = precio * (1-descuentoTotal);

        local.setPrecioTotal(precio);
        localizadores.add(local);
    }

    @Override
    public Integer getTotalLocalizadores() {
        return localizadores.size();
    }

    @Override
    public Integer getTotalReservas() { //Considerando reserva hotel
        return localizadores.stream().mapToInt(l -> l.getPaquete().getReserva().size()).sum();
    }

    @Override
    public Map<String, List<Object>> getPaquetesPorTipo() {
        Map<String, List<Object>> resultado = new HashMap<>();
        List<ReservaHotel> reservas = new ArrayList<>();
        List<Boleto> boletos = new ArrayList<>();
        List<Transporte> transportes = new ArrayList<>();
        List<Comida> comidas = new ArrayList<>();
        for (Localizador localizador: localizadores){
            reservas.addAll(localizador.getPaquete().getReserva());
            boletos.addAll(localizador.getPaquete().getBoleto());
            if(localizador.getPaquete().getTransporte() != null) {
                transportes.add(localizador.getPaquete().getTransporte());
            }
            comidas.addAll(localizador.getPaquete().getComida());
        }
        resultado.put("Reservas", Collections.singletonList(reservas));
        resultado.put("Comidas", Collections.singletonList(comidas));
        resultado.put("Boletos", Collections.singletonList(boletos));
        resultado.put("Transportes", Collections.singletonList(transportes));
        return resultado;
    }

    @Override
    public Integer getTotalVentas() {
        return localizadores.stream().mapToInt(l -> l.getPaquete().getReserva().size() +
                                                    l.getPaquete().getBoleto().size() +
                                                    l.getPaquete().getComida().size() +
                                                    (l.getPaquete().getTransporte() != null ? 1 : 0)).sum();
    }

    @Override
    public double getPromedioVentas() {
        return localizadores.stream().mapToDouble(Localizador::getPrecioTotal).average().getAsDouble();
    }
}
