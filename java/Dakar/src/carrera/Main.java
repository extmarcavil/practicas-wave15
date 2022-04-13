package carrera;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(230, 1200, "VueltaNocturna", 20,
                                        new SocorristaMoto(), new SocorristaAuto());
        carrera.darDeAltaAuto(40.5, 24.5, 30.5, "WG345HU");
        carrera.darDeAltaMoto(55.5, 25.5, 90.5, "KO456JK");
        carrera.socorrerAuto("WG345HU");
        carrera.socorrerAuto("KO456JK");
        carrera.definirGanador();
        carrera.eliminarVehiculoConPatente("KO456JK");
    }
}
