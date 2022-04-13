package ejercicio;

public class Main {

    public static void main(String[] args) {
        //Presentar un escenario donde:
        //Crear un localizador con un paquete completo para un cliente,
        // almacenar e imprimir el resultado.
        //Crear un localizador con 2 reservas de hotel y 2 de boletos para
        // el mismo cliente anterior, almacenar e imprimir el resultado.
        //Crear un localizador con una sola reserva para el mismo cliente.
        //Verificar que los descuentos fueron aplicados.

        //reservas de hotel, comida, boletos de viajes y transporte.

        Cliente nuevoCliente = new Cliente("Pepe");
        Transporte transporte = new Transporte(100);
        ReservaHotel reserva = new ReservaHotel();
        Comida comida = new Comida();
        BoletoDeViaje boletosAAustralia = new BoletoDeViaje();

        Paquete paqueteCompleto = new Paquete(nuevoCliente,reserva,comida,boletosAAustralia,transporte);
        ClaseRepositorio unaClaseRepo = new ClaseRepositorio( paqueteCompleto.getLocalizador());
        paqueteCompleto.imprimirLocalizador();

    }
}
