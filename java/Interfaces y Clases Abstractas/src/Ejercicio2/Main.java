package Ejercicio2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LibroPDF pdf = new LibroPDF(12,"Thiago","MundoNuevo","Ficcion");
        Impresora.imprimir(pdf);

        Informe informe = new Informe(20,40,"Thiago","Manuel");
        Impresora.imprimir(informe);
    }
}
