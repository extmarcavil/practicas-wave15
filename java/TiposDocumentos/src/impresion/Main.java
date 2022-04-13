package impresion;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] habilidades = {"Futbol", "Programacion"};
        Curriculum curriculum = new Curriculum("Josu", "Ment", "12324", "Soldado",
                                                Arrays.asList(habilidades));
        LibroPDF libroPDF = new LibroPDF("Alberto", "Costumbres", "Cultura",
                                        23, "Mucha informacion sobre cultura");
        Informe informe = new Informe("Tesis recien sacada del horno", 34, "Miguel", "Ricardo");

        Impresion.imprimir(curriculum);
        Impresion.imprimir(libroPDF);
        Impresion.imprimir(informe);
    }
}
