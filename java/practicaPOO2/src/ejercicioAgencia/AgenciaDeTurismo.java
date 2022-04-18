package ejercicioAgencia;

import ejercicioAgencia.repositorio.RepositorioCliente;
import ejercicioAgencia.repositorio.RepositorioLocalizador;

public class AgenciaDeTurismo {

    private RepositorioCliente repoCliente;
    private RepositorioLocalizador repoLocalizador;


    public AgenciaDeTurismo() {
        this.repoCliente = new RepositorioCliente();
        this.repoLocalizador = new RepositorioLocalizador();

    }


    public String calcularDescuentos(Localizador localizador, Cliente cliente) {
        String mensaje = "Este cliente no cuenta con descuentos";

        repoLocalizador.guardarLocalizador(localizador);
        repoCliente.agregarCliente(cliente);

        //Precio total por cada reserva en el localizador
        double precioTotalReservas = localizador.calcularPrecioTotalReservas() ;

        //Cantidad de localizadores asociados al mismo cliente
        int registros = (int) repoLocalizador.getLstLocalizadores().stream()
                .filter(localizador1 -> localizador1.getCliente().getDni() == cliente.getDni()).count();

        //Verificando si aplica descuento por cantidad de localizadores adquiridos
        if (repoLocalizador.getLstLocalizadores().contains(localizador) && registros >= 2) {
            System.out.println("Verificando cantidad de localizadores adquiridos..." + "\n");

            double descuento = precioTotalReservas - (precioTotalReservas * 0.05);

            System.out.println("El cliente " + cliente.getNombre() + " tiene un descuento del 5% en esta compra por haber adquirido 2 o más localizadores previamente." + "\n");
            mensaje = "El precio final con descuento incluido es de $" + descuento + "\n";
        }

        //Verificando si aplica descuento por paquete completo
        if (localizador.getPaquete().getLstReservas().size() == 4) {
            System.out.println("El Cliente cuenta con un paquete completo\n");
            double descuento = precioTotalReservas - (precioTotalReservas * 0.1);

            System.out.println("El Cliente " + cliente.getNombre() + " tiene un descuento del 10% en el paquete turistico\n");
            mensaje = "El precio final con descuento incluido es de $" + descuento + "\n";
        }

        //Verficando si aplica descuento por la compra de 2 reservas de hotel o 2 boletos de viaje.
        if (localizador.getPaquete().getLstReservas() != null) {

            for (Reserva reserva : localizador.getPaquete().getLstReservas()) {

                if ((reserva.getCantReservas() == 2 && reserva instanceof ReservaHotel) ||
                        (reserva.getCantReservas() == 2 && reserva instanceof ReservaBoleto)) {

                    if (reserva instanceof ReservaHotel)
                        System.out.println("El Cliente posee un descuento del 5% por la compra de 2 reservas de hotel \n");
                    else
                        System.out.println("El Cliente posee un descuento del 5% por la compra de 2 reservas de boleto \n");

                    double descuento = precioTotalReservas - (precioTotalReservas * 0.05);
                    mensaje = "El precio final con descuento incluido es de $" + descuento + "\n";
                }

            }
        }
        return mensaje;
    }
}
