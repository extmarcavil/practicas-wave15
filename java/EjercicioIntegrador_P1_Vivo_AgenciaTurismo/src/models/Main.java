package models;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        Cliente cliente1 = new Cliente("Juanito", "Alimaña","123456");

        Localizador l1 = new Localizador();
        l1.setCliente(cliente1);
        l1.agregarReserva(new Reserva("Hotel pao","Pescado fresco", "Boletos a cartagena","Transporte a la playa"));
        l1.setTotal(50000);

        repositorioLocalizador.agregarLocalizador(l1);
        repositorioCliente.setRepositorioLocalizador(repositorioLocalizador);

        Reserva r2 = new Reserva();
        r2.setHotel("Hotel locos por ti");
        r2.setBoletosDeViaje("Capurgana");

        l1.agregarReserva(r2);

        Reserva r3 = new Reserva();
        r3.setBoletosDeViaje("Santa marta");
        r3.setHotel("Taganga");
        l1.agregarReserva(r3);

        Cliente cliente2 = new Cliente("Benito", "Perez","78910");
        Localizador l2 = new Localizador();
        l2.setCliente(cliente2);
        Reserva reserva3 = new Reserva();
        reserva3.setHotel("Hostal la playa");
        l2.agregarReserva(reserva3);
        l2.setTotal(30000);


        repositorioLocalizador.agregarLocalizador(l2);
        repositorioCliente.setRepositorioLocalizador(repositorioLocalizador);
        repositorioCliente.imprimirLocalizadores();
        repositorioCliente.aplicarDescuentosTotales();
        repositorioCliente.imprimirLocalizadores();










    }
}
