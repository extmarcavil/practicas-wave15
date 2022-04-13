package impresionDocumentos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> hab = new ArrayList<>();
        hab.add("Habilidad 1");
        hab.add("Habilidad 2");
        hab.add("Habilidad 3");
        Persona p = new Persona(3834,"Gonzalo","Pichetti",hab);

        Curriculum curriculum = new Curriculum(p);
        LibroPDF libro = new LibroPDF(5,"Pedro","Drama", "El drama de pedro");
        Informe informe = new Informe(5,"Pedro","Textooooooo largooooo", "Juan");

        libro.imprimir();
        System.out.println("");

        informe.imprimir();
        System.out.println("");

        curriculum.imprimir();

    }
}
