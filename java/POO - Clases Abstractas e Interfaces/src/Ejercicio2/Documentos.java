package Ejercicio2;

import java.util.ArrayList;

public class Documentos {

    public static void main(String[] args) {
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Gambeta");
        habilidades.add("Tiro al arco");
        habilidades.add("Centro");
        habilidades.add("Veloz");

        Curriculums c = new Curriculums("Jose", habilidades);
        c.imprimible();

        Libro l = new Libro("Jorge Luis Borges", "Rayuela", "Ficcion", 500);
        l.imprimible();

        Informes i = new Informes(300,50,"Marcos Aguero","Jose Revisor");
        i.imprimible();
    }
}
