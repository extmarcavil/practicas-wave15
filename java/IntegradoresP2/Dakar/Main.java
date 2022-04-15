package IntegradoresP2.Dakar;

public class Main {
    public static void main(String[] args) {
        // Carrera de autos.
        Carrera<Auto> carreraAutos = new Carrera(1000, 1000, "Carrera de Autos", 4);
        System.out.println(carreraAutos.getNombre());
        System.out.println("----------------");

        // Creación de autos.
        Auto auto1 = new Auto(110, 20, 40, "AA111AA");
        Auto auto2 = new Auto(100, 10, 30, "AA222AA");
        Auto auto3 = new Auto(100, 30, 40, "AA333AA");
        Auto auto4 = new Auto(120, 10, 30, "AA444AA");
        Auto auto5 = new Auto(130, 20, 40, "AA555AA");

        // Agregar autos a la carrera.
        carreraAutos.darDeAltaVehiculo(auto1);
        carreraAutos.darDeAltaVehiculo(auto2);
        carreraAutos.darDeAltaVehiculo(auto3);
        carreraAutos.darDeAltaVehiculo(auto4);
        carreraAutos.darDeAltaVehiculo(auto5);

        // Eliminar un auto.
        carreraAutos.eliminarVehiculo(auto3);

        // Socorrer un auto.
        carreraAutos.socorrer("AA111AA");

        // Determinar el ganador.
        carreraAutos.determinarGanador();
    }
}
