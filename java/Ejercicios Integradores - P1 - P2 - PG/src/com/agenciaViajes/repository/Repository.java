package com.agenciaViajes.repository;

import com.agenciaViajes.model.Cliente;
import com.agenciaViajes.model.Localizador;
import com.agenciaViajes.model.PaqueteTuristico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    List<Localizador> localizadores = new ArrayList<>();

    public void guardar(Localizador localizador){
        cantidadDeLocalizadores(localizador.getCliente());
        localizador.setTotal(calcularTotal(localizador.getPaqueteTuristico(), localizador.getCliente()));
        localizadores.add(localizador);
    }

    public void mostrarPorId(String id){
        Localizador localizador = localizadores.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(localizador != null){
            System.out.println(localizador);
        } else {
            System.out.println("La informacion brindada es incorrecta.");
        }
    }

    private void cantidadDeLocalizadores(Cliente cliente){
       List<Localizador> l = localizadores.stream()
               .filter(x -> x.getCliente().getDni().equals(cliente.getDni())).collect(Collectors.toList());
       if(l.size() >= 2){
           l.get(0).getCliente().setDescuentoAcumulado(true);
       }
    }


    private double calcularTotal(PaqueteTuristico paqueteTuristico, Cliente cliente) {
        double descuento = 0.0;
        double total = 0.0;

        //Descuento acumulable por si anteriormente el cliente adquirio al menos dos localizadores
        //Si un cliente anteriormente adquirió al menos 2 localizadores,
        // se le descontará un 5% del total para futuras compras.
        if(cliente.isDescuentoAcumulado()){
            descuento += 0.05;
        }

        //Paquete turistico Completo id 1
        //Si un cliente adquiere un paquete completo que consiste en reserva de hotel,
        // comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
        if(paqueteTuristico.getId() == 1){
            descuento += 0.10;
        }

        //Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje,
        // se aplicará un descuento de 5% en esas reservas.
        if(paqueteTuristico.getBoletos() != null){
            if(paqueteTuristico.getBoletos().getCantidadBoletos() > 1){
                total += paqueteTuristico.getBoletos().getCosto() - (paqueteTuristico.getBoletos().getCosto() * 0.05);
            } else {
                total += paqueteTuristico.getBoletos().getCosto();
            }
        }
        if(paqueteTuristico.getHotel() != null){
            if(paqueteTuristico.getHotel().getCantidadReservas() > 1){
                total += paqueteTuristico.getHotel().getCosto() - (paqueteTuristico.getHotel().getCosto() * 0.05);
            } else {
                total += paqueteTuristico.getHotel().getCosto();
            }
        }
        if(descuento != 0){
            total = total - (total * descuento);
        }
        return total;
    }

}
