package Dakar;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Carrera dakar = new Carrera(42195, 1000, "Dakar", 5, new HashMap<>());
        dakar.darDeAltaAuto(10, 5, 60, "12345");
        dakar.darDeAltaAuto(15, 2, 65, "123");
        dakar.darDeAltaAuto(10, 6, 70, "12");
        dakar.darDeAltaMoto(20, 1, 64, "1234567");
        dakar.darDeAltaMoto(18, 2, 80, "1");
        dakar.darDeAltaAuto(12, 3, 90, "123456");

        Vehiculo ganador = dakar.getGanador();
        System.out.println(ganador);

    }
}
