import models.Cliente;
import models.Localizador;
import models.Reserva;

public class Main {
    public static void main(String[] args) {
        AgenciaDeViajes agenciaDeViajes = new AgenciaDeViajes();

        Cliente c1 = new Cliente("Cosme", "Fulanito", "123");
        Cliente c2 = new Cliente("Max", "Power", "124");
        Cliente c3 = new Cliente("Homero", "Thompson", "125");

        agenciaDeViajes.addCliente(c1);
        agenciaDeViajes.addCliente(c2);
        agenciaDeViajes.addCliente(c3);

        Reserva r1 = new Reserva();
        r1.setHotel("Hotel Magico");
        r1.setComida("Pack de comida Premium");
        r1.setBoletosDeViaje("Aerolineas Argentinas");
        r1.setTransporte("El remis de Pepe");

        Localizador l1 = new Localizador();
        l1.setCliente(c1);
        l1.setTotal(5000D);
        l1.addReserva(r1);

        Reserva r2 = new Reserva();
        r2.setHotel("Hotel Magico v2");
        r2.setBoletosDeViaje("FlyEmirates");

        Reserva r3 = new Reserva();
        r3.setHotel("Hotel de Villa Gesel");
        r3.setBoletosDeViaje("Plusmar");

        Localizador l2 = new Localizador();
        l2.setCliente(c1);
        l2.setTotal(8000D);
        l2.addReserva(r2);
        l2.addReserva(r3);

        Reserva r4 = new Reserva();
        r4.setBoletosDeViaje("Alto boleto");

        Localizador l3 = new Localizador();
        l3.setCliente(c1);
        l3.addReserva(r4);
        l3.setTotal(1000D);

        agenciaDeViajes.addLocalizador(l1);
        agenciaDeViajes.addLocalizador(l2);
        agenciaDeViajes.addLocalizador(l3);

        agenciaDeViajes.imprimirLocalizadores();
    }
}
