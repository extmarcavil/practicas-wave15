package com.company.agenciaDeTurismo;

import com.company.Localizador;
import com.company.Cliente;
import com.company.paqueteTuristico.PaqueteTuristico;
import com.company.repository.ClienteRepository;
import com.company.repository.LocalizadorRepository;

public class AgenciaDeTurismo {

    /**
     * Atributos
     */
    private ClienteRepository clienteRepository;
    private LocalizadorRepository localizadorRepository;


    /**
     * Constructor
     */
    public AgenciaDeTurismo() {
        this.clienteRepository = new ClienteRepository();
        this.localizadorRepository = new LocalizadorRepository();

    }

    /**
     * Metodos
     */
    public String descuentos(Localizador localizador, Cliente cliente) {

        // 1. Calculo el precio total de las reservas hechas por el cliente.
        double precioTotalDeReservas = localizador.calcularTotalDeReservas() ;

        String mensaje = "Este cliente no cuenta con descuentos";

        // 2. Almacenando el Localizador y el cliente en el Repository Correspondiente.
        localizadorRepository.guardarLocalizador(localizador);
        clienteRepository.agregarCliente(cliente);

        // 3. Verificando en el Repositorio de Localizadores la cantidad de localizadores a nombre del cliente
        int registros = (int) localizadorRepository.getHistorialDelCliente().stream()
                .filter(localizador1 -> localizador1.getCliente().getNombre().equals(cliente.getNombre())).count();

        // 4. Generando descuento correspondiente a haber adquirido 2 o mas localizadores.
        if (localizadorRepository.getHistorialDelCliente().contains(localizador) && registros >= 2) {

            System.out.println("El Cliente esta registrado en la base de datos" + "\n");
            System.out.println("Verificando cantidad de registros para el descuento del 5% en futuras compras" + "\n");

            double descuento = precioTotalDeReservas - (precioTotalDeReservas * 0.05);

            System.out.println("El cliente: " + cliente.getNombre() + " tiene un descuento del 5% en esta compra" + "\n");

            mensaje = "Costo total de la reserva: " + precioTotalDeReservas + " precio final a pagar con descuento incluido: " + descuento + "\n";

        }

        // 5. Generando descuento correspondiente a la compra de un paquete completo.
        if (localizador.getReservas().size() == 4) {

            System.out.println("El Cliente cuenta con un paquete Turistico Completo" + "\n");
            double descuento = precioTotalDeReservas - (precioTotalDeReservas * 0.1);

            System.out.println("El Cliente: " + cliente.getNombre() + " tendra acceso al descuento del 10% en el paquete turistico" + "\n");
            mensaje = "Costo total de la reserva: " + precioTotalDeReservas + " precio final a pagar con descuento incluido: " + descuento + "\n";
        }

        // 6. Gnerando descuento correspondiente a la compra de 2 reservas de hotel o 2 boletos de viaje.
        if (localizador.getReservas() != null) {
            int cantidad = 0;

            for (PaqueteTuristico reserva : localizador.getReservas()) {

                if ((reserva.getNumeroDeReservas() == 2 && reserva.getNombreDeLaReserva() == "reserva de hotel") ||
                        (reserva.getNumeroDeReservas() == 2 && reserva.getNombreDeLaReserva() == "boletos de viaje")) {

                    System.out.println("El Cliente contara con un descuento del 5% por la compra de 2 " + reserva.getNombreDeLaReserva() + "\n");
                    double descuento = precioTotalDeReservas - (precioTotalDeReservas * 0.05);

                    mensaje = "Costo total de la reserva: " + precioTotalDeReservas + " precio final a pagar con descuento incluido: " + descuento + "\n";
                }

            }
        }
        return mensaje;
    }
}
