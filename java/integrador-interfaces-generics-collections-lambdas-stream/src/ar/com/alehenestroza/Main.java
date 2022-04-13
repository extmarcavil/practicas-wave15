package ar.com.alehenestroza;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AgenciaTurismo agenciaTurismo = new AgenciaTurismo(new RepositorioCliente(), new RepositorioLocalizador());
        ArrayList<Producto> paquete = new ArrayList<>();
        Cliente cliente = new Cliente("Alejandro", "12345678");

        // Dto. por paquete completo
        paquete.add(new ReservaHotel(
                50000,
                "Sheraton",
                LocalDate.of(2022, 12, 12),
                LocalDate.of(2022, 12, 12)));
        paquete.add(new Comida(1000, "Milanesa con papas fritas"));
        paquete.add(new BoletosViaje(25000, "Mar del Plata", "Micro"));
        paquete.add(new Transporte(60, "Colectivo"));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

        // Dto. por dos reservas
        paquete = new ArrayList<>();
        paquete.add(new ReservaHotel(
                20000,
                "Sheraton 2",
                LocalDate.of(2022, 12, 12),
                LocalDate.of(2022, 12, 12)));
        paquete.add(new ReservaHotel(
                45000,
                "Sheraton 3",
                LocalDate.of(2022, 12, 12),
                LocalDate.of(2022, 12, 12)));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

        // Dto. por 2 localizadores previos
        paquete = new ArrayList<>();
        paquete.add(new ReservaHotel(
                10000,
                "Sheraton 4",
                LocalDate.of(2022, 12, 12),
                LocalDate.of(2022, 12, 12)));

        agenciaTurismo.agregarLocalizador(cliente, paquete);

    }
}
