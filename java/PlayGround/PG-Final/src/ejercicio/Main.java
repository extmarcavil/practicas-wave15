package ejercicio;

public class Main {

    public static void main(String[] args) {

        Cliente valeria = new Cliente("Valeria");

        BaseDeDatos baseDeDatosDeLaAgenciaDeTurismo = new BaseDeDatos();

        ReservaDeTransporte cochePrivado = new ReservaDeTransporte(1000);
        ReservaHotel hotel3Estrellas = new ReservaHotel(20000);
        ReservaHotel hotel4Estrellas = new ReservaHotel(50000);
        ReservaHotel hotel5Estrellas = new ReservaHotel(80000);
        ReservaDeComida comidaBasica = new ReservaDeComida(3000);
        ReservaDeComida comidaGourmet = new ReservaDeComida(5000);
        ReservaDeBoletoDeViaje boletoIDAEEUU = new ReservaDeBoletoDeViaje(200000);
        ReservaDeBoletoDeViaje boletoVUELTAEEUU = new ReservaDeBoletoDeViaje(200000);
        ReservaDeBoletoDeViaje boletoIDAAustralia = new ReservaDeBoletoDeViaje(400000);
        ReservaDeBoletoDeViaje boletoVUELTAAustralia = new ReservaDeBoletoDeViaje(400000);

        // Presentar un escenario donde:
        // Crear un localizador con un paquete completo para un cliente,
        // almacenar e imprimir el resultado.

        int numeroDeOperacion;

        Paquete primerPaqueteContratadoPorValeria = new Paquete();
        primerPaqueteContratadoPorValeria.crearPaqueteCompleto(hotel5Estrellas,comidaGourmet,cochePrivado,boletoIDAEEUU);
        numeroDeOperacion = baseDeDatosDeLaAgenciaDeTurismo.registrarCompraDePaquete(valeria,primerPaqueteContratadoPorValeria);
        baseDeDatosDeLaAgenciaDeTurismo.imprimirComprobante(numeroDeOperacion,valeria);

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para
        // el mismo cliente anterior, almacenar e imprimir el resultado.

        Paquete segundoPaqueteContratadoPorValeria = new Paquete();
        segundoPaqueteContratadoPorValeria.agregarAlPaquete(hotel5Estrellas);
        segundoPaqueteContratadoPorValeria.agregarAlPaquete(hotel5Estrellas);
        numeroDeOperacion = baseDeDatosDeLaAgenciaDeTurismo.registrarCompraDePaquete(valeria,segundoPaqueteContratadoPorValeria);
        baseDeDatosDeLaAgenciaDeTurismo.imprimirComprobante(numeroDeOperacion,valeria);

        // Crear un localizador con una sola reserva para el mismo cliente.
        // Verificar que los descuentos fueron aplicados.
        // reservas de hotel, comida, boletos de viajes y transporte.
        Paquete tercerPaqueteContratadoPorValeria = new Paquete();
        tercerPaqueteContratadoPorValeria.agregarAlPaquete(boletoVUELTAEEUU);
        numeroDeOperacion = baseDeDatosDeLaAgenciaDeTurismo.registrarCompraDePaquete(valeria,tercerPaqueteContratadoPorValeria);
        baseDeDatosDeLaAgenciaDeTurismo.imprimirComprobante(numeroDeOperacion,valeria);

    }
}
