public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100, 5000, "Dakar1", 5);
        carrera.darDeAltaAuto(200, 300, 180, "XXX 123");
        carrera.darDeAltaMoto(400, 200, 90,"YYY 555");
        carrera.definirGanador();

        //carrera.eliminarVehiculoConPatente("YYY 555");
        //carrera.definirGanador();

        carrera.socorrerMoto("YYY 555");
    }
}
