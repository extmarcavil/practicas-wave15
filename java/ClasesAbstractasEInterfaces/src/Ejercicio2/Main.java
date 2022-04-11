package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimible> imprimibles = new ArrayList<>();

        Curriculum c = new Curriculum();
        c.setDni("123");
        c.setNombre("Cosme fulanito");

        LibroPDF l = new LibroPDF();
        l.setCantidadDePaginas(2513);
        l.setGenero("Suspenso");
        l.setNombreAutor("Max Power");
        l.setTitulo("The Thompsoms");

        Informe i = new Informe();
        i.setAutor("Homero Thompson");
        i.setCantidadPaginas(12);
        i.setRevisor("Lisa Thompson");
        i.setTexto("Alto texto....");

        imprimibles.add(c);
        imprimibles.add(l);
        imprimibles.add(i);

        imprimibles.forEach(Imprimible::imprimir);
    }
}
