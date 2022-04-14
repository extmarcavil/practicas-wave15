package com;


import java.util.ArrayList;

public class Main {
    /*Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir algún paquete turístico,
    el cual consiste en reservas de hotel, comida, boletos de viajes y transporte. Las reservas son almacenadas en
    localizadores, los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo
    del producto adquirido. Por tanto los descuentos se aplicarán cuando:
    Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras
    compras.
    Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte,
    recibirá un descuento del 10% del total de la factura.
    Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
    Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los detalles de la compra.
    Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar descuentos; en caso de no existir el cliente poder agregarlo al repositorio cliente.

    Parte I
    Presentar un escenario donde:
    Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
    Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
    Crear un localizador con una sola reserva para el mismo cliente.
    Verificar que los descuentos fueron aplicados.


    Parte II (Opcional)
    Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos, empleando diferentes métodos que muestren:

    Cantidad de localizadores vendidos.
    Cantidad total de reservas.
    Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
    Total de ventas.
    Promedio de todas las ventas.
*/
    public static void main(String[] args) {

        Cliente cliente = new Cliente("ana", "paula", 4525, 3544324);

        ArrayList<Reserva> reservas = new ArrayList<>();

        Reserva reserva1 = new Reserva(500, "Reserva de Hotel");
        Reserva reserva2 = new Reserva(600, "Reserva de comida");
        Reserva reserva3 = new Reserva(800, "Reserva de boleto de viaje");
        Reserva reserva4 = new Reserva(900, "Reserva de transporte");

        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);
        reservas.add(reserva4);

        //Localizador localizador = new Localizador(reservas, cliente );
    }

}
