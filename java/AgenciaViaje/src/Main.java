import Modelo.*;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioLocalizador;
import Repositorios.Servicio;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AgenciaTurismo agenciaTurismo = new AgenciaTurismo(new RepositorioCliente(), new RepositorioLocalizador());
        ArrayList<Servicio> compra = new ArrayList<>();
        Cliente cliente = new Cliente("Mario Bros", "14023958");


        //paquete completo
        compra.add(new Hotel(28000,"Hotel 360"));
        compra.add(new Comida(150,"Spaghetti"));
        compra.add(new BoletosDeViajes(10000,"Mar del plata","Autobus"));
        compra.add(new Transporte(2000,"karting"));

        agenciaTurismo.agregarLocalizador(cliente,compra);


        //Dos hoteles
        compra.add(new Hotel(28000,"Hotel 360"));
        compra.add(new Hotel(15000,"UNO Hotel"));

        agenciaTurismo.agregarLocalizador(cliente,compra);


        //Dos localizadores previos
        compra.add(new Hotel(15500,"Hotelcito"));
        compra.add(new Transporte(2000,"karting"));

        agenciaTurismo.agregarLocalizador(cliente,compra);

        agenciaTurismo.getLocalizadores().getListado_localizadores().forEach(System.out::println);

    }
}
