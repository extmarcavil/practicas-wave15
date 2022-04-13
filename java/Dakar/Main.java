package Dakar;

public class Main {

    public static void main(String[] args) {

        System.out.println("Carrera de Dakar");

        Carrera carrera = new Carrera(1000.0, 1000000.0, "Dakar Argentina", 4);

        carrera.darDeAltaAuto(100.0, 10.0, 70.0, "abc");
        carrera.darDeAltaAuto(10.0, 30.0, 30.0, "def");
        carrera.darDeAltaAuto(20.0, 2.0, 90.0, "ghi");
        carrera.darDeAltaMoto(900.0, 140.0, 60.0, "mot");
        carrera.darDeAltaAuto(20.0, 2.0, 90.0, "jkl");
        carrera.darDeAltaMoto(900.0, 140.0, 60.0, "aut");

        Vehiculo ganador = carrera.ganador();

        System.out.println("El vehículo con patente " + ganador.getPatente() + " ha ganado $" + carrera.getPremioEnDolares());
        System.out.println("Con un récord de " + ganador.obtenerValor());
        
    }
}
