package Ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        Informe informe = new Informe("Hola mundo! Que tal? Como va? Saludos", 15, "Alejandro", "Santiago");
        LibroPDF libroPDF = new LibroPDF(100, "Axel", "No se", "Thriller");
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Programar");
        habilidades.add("Nadar con tiburones");
        habilidades.add("Alpinismo");
        Curriculum curriculum = new Curriculum("Jesus", "Leon", "11 de abril de 1996", habilidades);

        impresora.imprimir(informe);
        impresora.imprimir(libroPDF);
        impresora.imprimir(curriculum);
    }
}
