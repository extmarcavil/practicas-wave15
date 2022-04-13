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
        //Escenario 1 - Localizador con un paquete completo
        ReservaHotel hotel1 = new ReservaHotel(2000);
        ArrayList<ReservaHotel> lstHoteles1 = new ArrayList<>();
        lstHoteles1.add(hotel1);

        ReservaComida comida1 = new ReservaComida(500);
        ArrayList<ReservaComida> lstComidas1 = new ArrayList<>();
        lstComidas1.add(comida1);

        ReservaBoleto boleto1 = new ReservaBoleto(1500);
        ArrayList<ReservaBoleto> lstBoletos1 = new ArrayList<>();
        lstBoletos1.add(boleto1);

        ReservaTransporte transporte1 = new ReservaTransporte(100);
        ArrayList<ReservaTransporte> lstTransporte1 = new ArrayList<>();
        lstTransporte1.add(transporte1);

        Paquete paqueteCompleto = new Paquete(lstHoteles1, lstComidas1, lstBoletos1, lstTransporte1);

        Localizador localizador1 = new Localizador(paqueteCompleto);
        ArrayList<Localizador> lstLocalizadores = new ArrayList<>();
        lstLocalizadores.add(localizador1);
        long dni = 123456789;
        String nombre = "Nicolás";

        Cliente cliente = new Cliente(dni, nombre, lstLocalizadores);

        System.out.println(cliente.toString());
    }
}
