package dakar;

public class Main {

    public static void main(String[] args) {

        Carrera carrera = new Carrera(200,150000,"El desierto", 5);
        carrera.darDeAltaAuto(150,60,55,"AAA123");
        carrera.darDeAltaAuto(167,60,45,"ABC111");
        carrera.darDeAltaAuto(134,49,45,"BBB777");
        carrera.darDeAltaMoto(210,90,78,"MOT123");
        carrera.darDeAltaMoto(189,90,78,"MOT987");
        carrera.darDeAltaMoto(165,90,78,"MOT567");

        carrera.mostrarVehiculos();
        System.out.println(" --- ");
        carrera.eliminarVehiculoConPatente("BBB777");
        System.out.println(" --- ");
        carrera.mostrarVehiculos();
        System.out.println(" --- ");

        carrera.socorrerAuto("AAA123");
        carrera.socorrerMoto("MOT123");

        Vehiculo vehiculoGanador = carrera.obtenerGanador();
        System.out.println(vehiculoGanador);


    }
}
