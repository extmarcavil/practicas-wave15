package EjercicioIntegrador.SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        Prototipo pro = new PrototipoIniciador();
        System.out.println("-------------------------------------------------------");
        System.out.println("Series numericas de 2 en 2");
        pro.setSerie(2);
        pro.siguienteSerie();
        pro.siguienteSerie();
        pro.siguienteSerie();
        pro.siguienteSerie();

        System.out.println("-------------------------------------------------------");

        Prototipo prototipo = new PrototipoIniciador();
        System.out.println("Series Numericas de 8, con un iniciador en 4");
        prototipo.iniciarSerie(4);
        prototipo.setSerie(8);
        prototipo.siguienteSerie();
        prototipo.siguienteSerie();
        prototipo.siguienteSerie();
        prototipo.siguienteSerie();
        prototipo.siguienteSerie();

        Prototipo prototipo1 = new PrototipoIniciadorReset();
        System.out.println("-------------------------------------------------------");
        System.out.println("Series numericas de 3, iniciado en 7 con un reset en 19");
        prototipo1.iniciarSerie(7);
        prototipo1.setSerie(3);
        prototipo1.siguienteSerie();
        prototipo1.siguienteSerie();
        prototipo1.siguienteSerie();
        prototipo1.siguienteSerie();
        ((PrototipoIniciadorReset) prototipo1).reset();
        prototipo1.siguienteSerie();


    }
}
