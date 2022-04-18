package ejercicioAgencia;

/*Agencia de turismo
Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir algún paquete turístico, el cual
consiste en reservas de hotel, comida, boletos de viajes y transporte. Las reservas son almacenadas en localizadores,
los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo del producto adquirido.
Por tanto los descuentos se aplicarán cuando:
Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte,
recibirá un descuento del 10% del total de la factura.
Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los
detalles de la compra.
Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar descuentos;
en caso de no existir el cliente poder agregarlo al repositorio cliente.

Parte I
Presentar un escenario donde:
Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el
resultado.
Crear un localizador con una sola reserva para el mismo cliente.
Verificar que los descuentos fueron aplicados.*/


import java.util.ArrayList;

public class EjercicioAgencia {

    public static void main(String[] args) {
        //Creo la agencia de turismo
        AgenciaDeTurismo agencia = new AgenciaDeTurismo();

        //Escenario 1 - Localizador con un paquete completo
        Reserva hotel1 = new ReservaHotel(2000, 1);
        Reserva comida1 = new ReservaComida(500, 1);
        Reserva boleto1 = new ReservaBoleto(1500, 1);
        Reserva transporte1 = new ReservaTransporte(100, 1);
        ArrayList<Reserva> lstReservas1 = new ArrayList<>();
        lstReservas1.add(hotel1);
        lstReservas1.add(comida1);
        lstReservas1.add(boleto1);
        lstReservas1.add(transporte1);
        Paquete paqueteCompleto = new Paquete(lstReservas1);

        long dni = 123456789;
        String nombre = "Nicolás";
        Cliente cliente = new Cliente(dni, nombre);

        Localizador localizador1 = new Localizador(cliente, paqueteCompleto);
        System.out.println("Nuevo Localizador:");
        System.out.println(agencia.calcularDescuentos(localizador1, localizador1.getCliente()));

        //Escenario 2 - Localizador con 2 reservas de hotel y de boletos
        Reserva hotel2 = new ReservaHotel(2000, 2);
        Reserva boleto2 = new ReservaBoleto(1500, 2);
        ArrayList<Reserva> lstReservas2 = new ArrayList<>();
        lstReservas2.add(hotel2);
        lstReservas2.add(boleto2);
        Paquete paqueteHotelBoleto = new Paquete(lstReservas2);

        Localizador localizador2 = new Localizador(cliente, paqueteHotelBoleto);
        System.out.println("Nuevo Localizador:");
        System.out.println(agencia.calcularDescuentos(localizador2, localizador2.getCliente()));

        //Escenario 3 - Localizador con una sola reserva
        Reserva comida2 = new ReservaComida(500, 1);
        ArrayList<Reserva> lstReservas3 = new ArrayList<>();
        lstReservas3.add(comida2);
        Paquete paqueteUnaReserva = new Paquete(lstReservas3);

        Localizador localizador3 = new Localizador(cliente, paqueteUnaReserva);
        System.out.println("Nuevo Localizador:");
        System.out.println(agencia.calcularDescuentos(localizador3, localizador3.getCliente()));
    }
}
