package agencia;

import modelos.*;
import repositorio.RepositorioCliente;
import repositorio.RepositorioLocalizador;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AgenciaTurismo agenciaTurismo = new AgenciaTurismo(new RepositorioCliente(), new RepositorioLocalizador());
        ArrayList<Producto> paquete = new ArrayList<>();
        Cliente cliente = new Cliente("Alejandro", "12345678");

        // Dto. por paquete completo
        paquete.add(new ReservaHotel(
                "Reserva",
                50000,
                "Sheraton",
                new Date("12/12/2022"),
                new Date("20/12/2022")));
        paquete.add(new Comida("Comida", 1000, "Milanesa con papas fritas"));
        paquete.add(new BoletosViaje("Boletos", 25000, "Mar del Plata", "Micro"));
        paquete.add(new Transporte("Transporte", 60, "Colectivo"));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

        // Dto. por dos reservas
        paquete = new ArrayList<>();
        paquete.add(new ReservaHotel(
                "Reserva",
                20000,
                "Sheraton 2",
                new Date("12/12/2022"),
                new Date("20/12/2022")));
        paquete.add(new ReservaHotel(
                "Reserva",
                45000,
                "Sheraton 3",
                new Date("12/12/2022"),
                new Date("20/12/2022")));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

        // Dto. por 2 localizadores previos
        paquete = new ArrayList<>();
        paquete.add(new ReservaHotel(
                "Reserva",
                10000,
                "Sheraton 4",
                new Date("12/12/2022"),
                new Date("20/12/2022")));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

    }
}
