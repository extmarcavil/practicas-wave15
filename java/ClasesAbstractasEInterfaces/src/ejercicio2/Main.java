package ejercicio2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Imprimible curriculum = new Curriculum();
        curriculum.imprimir();

        Imprimible informe = new Informes(80, 2, "Juan Pérez", "Lucas Perez");
        informe.imprimir();

        Imprimible librosPdf = new LibrosPdf(287, "Taylor Jenkins Reid", "Los siete maridos de Evelyn Hugo", "Novela");
        librosPdf.imprimir();

    }
}
