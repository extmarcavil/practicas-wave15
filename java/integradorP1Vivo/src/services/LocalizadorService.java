package services;

import model.*;
import repository.LocalizadorRepository;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorService {

    private final LocalizadorRepository localizadorRepository = new LocalizadorRepository();

    public List<Localizador> listarLocalizadores(){
        return localizadorRepository.findAll();
    }

    /**
     * Cuando se crea el localizador deberia calcularse el monto
     * @param localizador
     * @return
     */
    public Localizador crearLocalizador(Localizador localizador){
        return localizadorRepository.create(totalPagar(localizador));
    }


    /**
     * Se haran descuentos cuando:
     *      el cliente tenga dos localizadores ya comprados
     *      el cliente compre un paquete completo (todos los tipos de reserva)
     *      el cliente compre 2 reservas iguales (2 reservas de hotel o 2 reservas de viaje) este descuento se hace
     *      sobre el precio de la reserva
     *
     *      Los descuentos son acumulativos es decir
     * @return
     */
    private Localizador totalPagar(Localizador localizador){
        List<Reserva> reservaList=localizador.getReservas();
        Boolean descuentoPorDosHotel=reservaList.stream()
                                                .filter(Hotel.class::isInstance)
                                                .count()==2;
        Boolean descuentoPorDosBoletoViaje =reservaList.stream()
                .filter(BoletoViaje.class::isInstance)
                .count()==2;



        Boolean descuentoLocalizadores=false;
        List<Localizador> localizadors=localizadorRepository.findByCliente(localizador.getCliente());
        if (localizadors != null) {
            descuentoLocalizadores=localizadors.size()>1;
        }

        Double total =0.;
        Boolean isHotel=false,isBoletoViaje=false,isTransporte=false,isComida=false;

        for (Reserva reserva: reservaList) {
            if(descuentoPorDosHotel && reserva instanceof Hotel) {
                ((Hotel) reserva).setDescuento(new Descuento(5,"Doble Hotel"));
                total+=reserva.getPrecio()*.95;
            } else if (descuentoPorDosBoletoViaje && reserva instanceof BoletoViaje) {
                ((BoletoViaje) reserva).setDescuento(new Descuento(5,"Doble Boleto de Viaje"));
                total+=reserva.getPrecio()*.95;
            }else {
                total+=reserva.getPrecio();
            }
            if (reserva instanceof Hotel) isHotel=true;
            if (reserva instanceof BoletoViaje) isBoletoViaje=true;
            if (reserva instanceof Transporte) isTransporte=true;
            if (reserva instanceof Comida) isComida=true;
        }

        double descuento=1;
        List<Descuento> descuentos=new ArrayList<>();
        if(descuentoLocalizadores) {
            descuento -= .05;
            descuentos.add(new Descuento(5,"Descuento por Localizadores"));
        }
        if (isHotel && isComida && isBoletoViaje && isTransporte) {
            descuento -= .1;
            descuentos.add(new Descuento(10,"Descuento por Paquete Completo"));
        }
        total*=descuento;

        localizador.setTotal(total);
        localizador.setDescuentos(descuentos);


        return localizador;
    }

}
