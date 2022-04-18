package AgenciaTurismo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LocalizadorRepositorio repoLocalizador = new LocalizadorRepositorio();
        ClienteRepositorio clienteLocalizador = new ClienteRepositorio();

        Cliente cliente = new Cliente("Juan", "40887712");
        clienteLocalizador.agregar(cliente);
        ReservaHotel reserva = new ReservaHotel(100);
        Comida comida = new Comida(15);
        Boleto boleto = new Boleto(100);
        Transporte transporte = new Transporte(200);

        ArrayList<Comida> listadoComida = new ArrayList<Comida>();
        listadoComida.add(comida);
        ArrayList<ReservaHotel> listadoReserva = new ArrayList<ReservaHotel>();
        listadoReserva.add(reserva);
        ArrayList<Boleto> listadoBoleto = new ArrayList<Boleto>();
        listadoBoleto.add(boleto);

        Paquete paquete1 = new Paquete();
        paquete1.setBoleto(listadoBoleto);
        paquete1.setComida(listadoComida);
        paquete1.setReserva(listadoReserva);
        paquete1.setTransporte(transporte);

        Localizador localizador = new Localizador(paquete1,cliente);
        repoLocalizador.agregar(localizador);
        System.out.println(repoLocalizador.getListadoLocalizadores());
        System.out.println("------------------------------");
        System.out.println("Cantidad de localizadores vendidos:");
        System.out.println(repoLocalizador.getCantidadLocalidazoresVendidos());
        System.out.println("------------------------------");
        System.out.println("Cantidad de reservas:");
        System.out.println(repoLocalizador.getCantidadReservas());

    }
}
