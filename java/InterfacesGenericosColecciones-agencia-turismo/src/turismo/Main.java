package turismo;

import turismo.reservas.BoletosViaje;
import turismo.reservas.Comida;
import turismo.reservas.ReservaHotel;
import turismo.reservas.Transporte;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Cliente cliente1 = new Cliente("123");

        List<Reserva> reservas1 = new ArrayList<>();
        reservas1.add(new Comida());
        reservas1.add(new BoletosViaje());

        Localizador localizador1 = new Localizador(cliente1, new Paquete(reservas1));
        cliente1.addLocalizador(localizador1);

        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(new ReservaHotel());
        reservas2.add(new Transporte());

        Localizador localizador2 = new Localizador(cliente1, new Paquete(reservas2));
        cliente1.addLocalizador(localizador2);



    }
}
