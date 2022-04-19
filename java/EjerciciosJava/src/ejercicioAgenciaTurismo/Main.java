package ejercicioAgenciaTurismo;

public class Main {
    public static void main(String[] args) {

        Transporte transporte1 = new Transporte("Colectivo", 150);
        Transporte transporte2 = new Transporte("Taxi", 200);

        Boleto boleto1 = new Boleto("Buenos Aires", "Sao Pablo", 1000);
        Boleto boleto2 = new Boleto("Sao Pablo", "Brasilia", 500);

        Hotel hotel1 = new Hotel("Grand Luxor", 400);
        Hotel hotel2 = new Hotel("Estrella Azul", 600);

        Comida comida1 = new Comida("Desayuno", 80);
        Comida comida2 = new Comida("Almuerzo", 100);
        Comida comida3 = new Comida("Cena", 120);

        PaqueteTuristico paquete1 = new PaqueteTuristico();
        paquete1.addBoleto(boleto1);
        paquete1.addComida(comida1);
        paquete1.addHotel(hotel1);
        paquete1.addTransporte(transporte2);

        PaqueteTuristico paquete2 = new PaqueteTuristico();
        paquete2.addHotel(hotel1);
        paquete2.addHotel(hotel2);
        paquete2.addBoleto(boleto1);
        paquete2.addBoleto(boleto2);

        PaqueteTuristico paquete3 = new PaqueteTuristico();
        paquete3.addHotel(hotel2);

        Cliente cliente1 = new Cliente("Edgar", "35573378");

        Localizador localizador1 = new Localizador(cliente1, paquete1);
        Localizador localizador2 = new Localizador(cliente1, paquete2);
        Localizador localizador3 = new Localizador(cliente1, paquete3);

        Repositorio repo = new Repositorio();
        repo.addLocalizador(localizador1);
        repo.addLocalizador(localizador2);
        repo.addLocalizador(localizador3);

        System.out.println("Total Ventas");
        ConsultasVentas.totalVentas(repo);
        System.out.println("Promedio Ventas");
        ConsultasVentas.promedioVentas(repo);
        System.out.println("Localizadores Vendidos");
        ConsultasVentas.localizadoresVendidos(repo);
        System.out.println("Cantidad de Reservas");
        ConsultasVentas.cantidadTotalReservas(repo);

    }
}
