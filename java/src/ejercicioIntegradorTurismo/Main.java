package ejercicioIntegradorTurismo;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(38,"Juan", "Perez");
        Reserva reserva = new Reserva(cliente,ReservaType.RESERVA_HOTEL,500.00);
        Reserva reserva1 = new Reserva(cliente,ReservaType.BOLETO_VIAJE,200.00);
        Reserva reserva2 = new Reserva(cliente,ReservaType.COMIDA,100.00);
        Reserva reserva3 = new Reserva(cliente,ReservaType.TRANSPORTE,300.00);
        ArrayList<Reserva> listaReservas = new ArrayList<>();

        int[] numeros = new int[5];
        try{
            numeros[5] = 10;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("mensajeFinal");
        }

        listaReservas.add(reserva);
        listaReservas.add(reserva1);
        listaReservas.add(reserva2);
        listaReservas.add(reserva3);
        Localizador localizador = new Localizador(1,cliente,listaReservas);

        HashMap<Integer,Localizador> repositorioLocalizador = new HashMap<>();
        repositorioLocalizador.put(localizador.getId(),localizador);

        repositorioLocalizador.forEach((x,y) -> System.out.println(y));


        reserva = new Reserva(cliente,ReservaType.RESERVA_HOTEL,500.00);
        reserva1 = new Reserva(cliente,ReservaType.BOLETO_VIAJE,200.00);

        listaReservas = new ArrayList<>();
        listaReservas.add(reserva);
        listaReservas.add(reserva1);
        localizador = new Localizador(2,cliente,listaReservas);

        repositorioLocalizador.put(localizador.getId(),localizador);
        repositorioLocalizador.forEach((x,y) -> {
            System.out.println("ID de Localizador: " + x);
            System.out.println("Datos del Localizador: " + y);
        });

    }
}

