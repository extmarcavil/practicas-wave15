package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente roberto = new Cliente("123123","Roberto","Sosa");
        List<Reserva> reservasRoberto = new ArrayList<>();

        Hotel hotel1 = new Hotel(250,10 ,"El Hotel de la esquina");
        Comida comida1 = new Comida(250,"Burger King","Big Mac");
        Viaje viaje1 = new Viaje(250,"Transpuntano","VIP",LocalDate.now());
        Transporte transporte1 = new Transporte(250,"Taxi");

        reservasRoberto.add(hotel1);
        reservasRoberto.add(comida1);
        reservasRoberto.add(viaje1);
        reservasRoberto.add(transporte1);

        Localizador lRoberto = new Localizador(roberto,reservasRoberto);
        System.out.println("___________");
        System.out.println("Precio del localizador completo");
        System.out.println(lRoberto.getTotalPrice());
        roberto.setLocalizador(lRoberto);
        //limpio para reuzar el mismo arraylist
        reservasRoberto.clear();
        System.out.println("___________");

        reservasRoberto.add(hotel1);
        reservasRoberto.add(hotel1);
        reservasRoberto.add(viaje1);
        reservasRoberto.add(viaje1);

        Localizador lRoberto2 = new Localizador(roberto,reservasRoberto);
        System.out.println("Precio de localizador doble hotel doble viaje");
        System.out.println(lRoberto2.getTotalPrice());
        roberto.setLocalizador(lRoberto2);
        //limpio para reuzar el mismo arraylist
        reservasRoberto.clear();
        System.out.println("___________");

        reservasRoberto.add(hotel1);

        Localizador lRoberto3 = new Localizador(roberto,reservasRoberto);
        System.out.println("Precio de localizador simple, pero con dos localizadores previos");
        System.out.println(lRoberto3.getTotalPrice());
        roberto.setLocalizador(lRoberto3);
        System.out.println("___________");
    }
}
