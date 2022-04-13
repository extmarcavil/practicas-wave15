import models.Auto;
import models.Carrera;
import models.Moto;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(
                12.9F,
                10000F,
                "Grand Prix Termas de Rio Hondo",
                3);

        carrera.darDeAltaAuto(120F, 100F, 10.2F, "111");
        carrera.darDeAltaMoto(150F, 120F, 10.8F, "112");
        carrera.darDeAltaMoto(140F, 160F, 11.1F, "113");

        carrera.darDeAltaAuto(120F, 100F, 10.2F, "114");

        carrera.socorrerAuto("111");

        System.out.println("Ganador " + carrera.ganador());
    }
}
