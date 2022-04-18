package ejercicio;

public class Main {

    public static void main(String[] args) {
        Cliente nuevoCliente = new Cliente("Pepe");
        Transporte transporte = new Transporte(100);
        ReservaHotel reserva = new ReservaHotel();
        Comida comida = new Comida();
        BoletoDeViaje boletos = new BoletoDeViaje();

        Paquete paqueteCompleto = new Paquete(nuevoCliente, reserva, comida, boletos,transporte);
        ClaseRepositorio unaClaseRepo = new ClaseRepositorio( paqueteCompleto.getLocalizador());
        paqueteCompleto.imprimirLocalizador();

    }
}
