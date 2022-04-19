public class Main {

    public static void main(String[] args) {

        Paquete paqueteCompleto = new Paquete();
        paqueteCompleto.agregarReserva(new ReservaHotel(1000));
        paqueteCompleto.agregarReserva(new ReservaBoleto(1500));
        paqueteCompleto.agregarReserva(new ReservaComida(500));
        paqueteCompleto.agregarReserva(new ReservaTransporte(200));

        Localizador localizadorPaqueteCompleto = new Localizador(paqueteCompleto);

        Cliente cliente = new Cliente();
        cliente.agregarLocalizador(localizadorPaqueteCompleto);

        Facturacion facturacion = new Facturacion(cliente);
        double precioPaqueteCompleto = facturacion.facturarCompraPaquete(paqueteCompleto);

        System.out.println("Precio final paquete completo, deberia tener 10% de decuento: $" + precioPaqueteCompleto);

        Paquete paqueteConDosReservasDeHotelYBoletos = new Paquete();
        paqueteConDosReservasDeHotelYBoletos.agregarReserva(new ReservaHotel(1000));
        paqueteConDosReservasDeHotelYBoletos.agregarReserva(new ReservaHotel(1000));
        paqueteConDosReservasDeHotelYBoletos.agregarReserva(new ReservaBoleto(1500));
        paqueteConDosReservasDeHotelYBoletos.agregarReserva(new ReservaBoleto(1500));

        Localizador localizadorConDosReservasDeHotelYBoletos = new Localizador(paqueteConDosReservasDeHotelYBoletos);

        cliente.agregarLocalizador(localizadorConDosReservasDeHotelYBoletos);

        double precioPaqueteConDosReservasDeHotelYBoletos = facturacion.facturarCompraPaquete(paqueteConDosReservasDeHotelYBoletos);
        System.out.println("Precio final paquete con dos reservas de hotel y dos de boletos, debe tener un 5% de decuento: $" + precioPaqueteConDosReservasDeHotelYBoletos);

        Paquete paqueteConUnaSolaReserva = new Paquete();
        paqueteConUnaSolaReserva.agregarReserva(new ReservaBoleto(1500));

        Localizador localizadorConUnaSolaReserva = new Localizador(paqueteConUnaSolaReserva);

        cliente.agregarLocalizador(localizadorConUnaSolaReserva);

        double precioPaqueteConUnaSolaReserva = facturacion.facturarCompraPaquete(paqueteConUnaSolaReserva);
        System.out.println("Precio final paquete con una sola reserva, deberia tener descuento del 5%: $" + precioPaqueteConUnaSolaReserva);
    }
}
