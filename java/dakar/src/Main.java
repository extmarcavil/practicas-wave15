public class Main {
    public static void main(String[] args) {

        System.out.println("Nueva carrera Dakar");
        Carrera carrera = new Carrera(500, 8999, "Dakar", 5);
        carrera.darDeAltaAuto(350, 9, 70, "AA000AA");
        carrera.darDeAltaAuto(245, 4, 55, "AA000AB");
        carrera.darDeAltaAuto(212, 11, 33, "AA000AC");
        carrera.darDeAltaAuto(221, 22, 44, "AA000AD");
        carrera.darDeAltaAuto(321, 7, 99, "AA000AE");

        System.out.println("Agregando los 5 autos");

        System.out.println("No se tendria que poder agregar un 6to");
        carrera.darDeAltaAuto(321, 7, 99, "AA000AE");

        System.out.println(carrera.calcularGanador());

        carrera.socorrerAuto("AA000AC");
    }
}