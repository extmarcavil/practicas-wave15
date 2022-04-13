import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(
                1000.0,
                100000.0,
                "Carrera de Prueba",
                9
        );

        carrera.darDeAltaAuto(200.0, 10.0, 60.0, "abcde1");
        carrera.darDeAltaAuto(220.0, 9.0, 56.0, "abcde2");
        carrera.darDeAltaAuto(210.0, 10.5, 67.0, "abcde3");
        carrera.darDeAltaAuto(190.0, 8.0, 64.0, "abcde4");
        carrera.darDeAltaAuto(205.0, 7.0, 58.0, "abcde5");
        carrera.darDeAltaAuto(200.0, 10.0, 60.0, "abcde1");

        carrera.darDeAltaMoto(220.0, 7.0, 60.0, "abcde6");
        carrera.darDeAltaMoto(210.0, 10.0, 60.0, "abcde7");
        carrera.darDeAltaMoto(195.0, 9.0, 60.0, "abcde8");
        carrera.darDeAltaMoto(210.0, 9.0, 60.0, "abcde9");
        carrera.darDeAltaMoto(240.0, 10.0, 60.0, "abcde10");

        System.out.println("\n");

        ArrayList<Vehiculo> vehiculos;
        vehiculos = carrera.getListaDeVehiculos();
        vehiculos.stream().forEach(System.out::println);

        System.out.println("\n");

        carrera.eliminarVehiculo(vehiculos.get(0));

        System.out.println("\n");

        vehiculos = carrera.getListaDeVehiculos();
        vehiculos.stream().forEach(System.out::println);

        carrera.eliminarVehiculoConPatente("abcde1");
        carrera.eliminarVehiculoConPatente("abcde2");

        System.out.println("\n");

        vehiculos = carrera.getListaDeVehiculos();
        vehiculos.stream().forEach(System.out::println);

        carrera.darDeAltaAuto(200.0, 10.0, 60.0, "abcde11");
        carrera.darDeAltaAuto(220.0, 9.0, 56.0, "abcde12");

        System.out.println("\n");

        vehiculos = carrera.getListaDeVehiculos();
        vehiculos.stream().forEach(System.out::println);

        System.out.println("\n");
        carrera.socorrerAuto("abcde6");
        carrera.socorrerAuto("abcde5");

        carrera.socorrerMoto("abcde6");

        System.out.println("\n");

        carrera.ganador();

    }
}
