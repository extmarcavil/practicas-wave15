package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        LibroPDF pdf = new LibroPDF(400, "Juan", "Hola", "Cuentos");
        Impresora.imprimir(pdf);

        List<String> lista = new ArrayList<>();

        Curriculum curriculum = new Curriculum("Nicolas", 24, "adsd", lista);
        Impresora.imprimir(curriculum);

        Informe informe = new Informe(200, 210, "Juan", "Pedro");
        Impresora.imprimir(informe);
    }

}
