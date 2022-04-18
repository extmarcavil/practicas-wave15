import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Auto auto1 = new Auto(120.0,50.0, 50d, "AAA");
        Auto auto2 = new Auto(130.0,50.0, 50d, "BBB");
        Moto moto1 = new Moto(100d, 40d, 20d, "CCC");
        Moto moto2 = new Moto(90d, 30d, 10d, "DDD");

        Carrera carrera = new Carrera(10000.0, 100.0, "La carrera", 10);
        carrera.setListaVehiculos(new ArrayList<>(List.of(auto1, auto2, moto2, moto1)));
        carrera.setSocorristaAuto(new SocorristaAuto(100d, 50d, 50d, "AAB", 400d, 4));
        carrera.setSocorristaMoto(new SocorristaMoto(100d, 50d, 50d, "AAC", 400d, 4));
        carrera.darDeAltaAuto(130.0,50.0, 50d, "EEE");
        carrera.darDeAltaMoto(130.d, 80d, 90d, "MMM");
        
        System.out.println(carrera.getListaVehiculos());

        System.out.println("Auto ganador: " + carrera.ganador(4));
        System.out.println("Moto ganadora: " + carrera.ganador(2));
        carrera.socorrerMoto("MMM");
        carrera.socorrerAuto("DDD");
    }
}
