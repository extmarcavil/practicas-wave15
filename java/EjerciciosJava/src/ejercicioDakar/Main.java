package ejercicioDakar;

public class Main {
    public static void main(String[] args) {
        Carrera carreraMotos = new Carrera(100, 1000, "DakarMoto", 2);
        Carrera carreraAutos = new Carrera(200, 1500, "Dakar Auto", 3);

        carreraMotos.darDeAltaMoto(150, 20, 40, "abc123");
        carreraMotos.darDeAltaMoto(150, 20, 40, "abc223");
        carreraMotos.darDeAltaMoto(120, 30, 35, "abc123");
        System.out.println();
        carreraMotos.eliminarVehiculoPorPatente("abc124");
        carreraMotos.eliminarVehiculoPorPatente("abc123");
        carreraMotos.darDeAltaMoto(120, 30, 35, "abc123");
        carreraMotos.socorrerMoto("abc124");
        carreraMotos.socorrerMoto("abc123");
        carreraMotos.calcularGanador();

        System.out.println();
        carreraAutos.darDeAltaAuto(200, 15, 50, "asd321");
        carreraAutos.darDeAltaAuto(210, 14, 52, "asd121");
        carreraAutos.darDeAltaAuto(195, 17, 48, "asd331");
        carreraAutos.darDeAltaAuto(190, 20, 55, "asd521");
        carreraAutos.calcularGanador();


    }
}
