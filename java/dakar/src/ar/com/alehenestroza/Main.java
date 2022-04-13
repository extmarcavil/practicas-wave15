package ar.com.alehenestroza;

public class Main {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(58.5, 4500, "Bs. As. - Lujan", 4);

        carrera.darDeAltaAuto(80, 15.5, 45.8, "ABC123");
        carrera.darDeAltaAuto(80, 15.5, 45.8, "DFG456");
        carrera.darDeAltaAuto(80, 15.5, 45.8, "ABC123");
        carrera.darDeAltaMoto(90, 15.3, 27.8, "HIJ789");
        carrera.darDeAltaMoto(90, 20.3, 27.8, "KLM101");
        carrera.darDeAltaMoto(90, 15, 27.8, "AEW456");

        carrera.socorrerAuto("ABC123");
        carrera.socorrerAuto("456ASD");
        carrera.socorrerAuto("HIJ789");
        carrera.socorrerMoto("KLM101");

        System.out.println(carrera.getGanador());

        carrera.eliminarVehiculoPorPatente("KLM101");
        System.out.println(carrera.getGanador());
    }
}
