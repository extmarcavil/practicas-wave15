public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(300,5000,"Carrera de Abu Dhabi",5);

        carrera.darDeAltaAuto(70,50,15,"ABC123");
        carrera.darDeAltaAuto(67,46,20,"XYQ558");
        carrera.darDeAltaMoto(50,33,10,"HYG55N");
        carrera.darDeAltaMoto(45,35,12,"EEE55E");
        carrera.darDeAltaMoto(43,40,14,"KAL158");

        carrera.imprimirVehiculos();
        carrera.eliminarVehiculoConPatente("KAL158");
        carrera.imprimirVehiculos();

        carrera.eliminarVehiculo();

        System.out.println("----------------");
        System.out.println("El ganador es:");
        carrera.imprimirGanador();

        System.out.println("----------------");
        System.out.println("Socorriendo el auto");
        carrera.socorrerAuto("ABC123");
        System.out.println("Socorriendo el Moto");
        carrera.socorrerMoto("EEE55E");
    }
}
