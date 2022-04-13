package ejercicioDocumentos;

/*Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.
Entre los tipos de documentos se encuentran:

Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático de
una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido.*/

import java.util.ArrayList;

public class EjercicioDocumentos {
    public static void main(String[] args) {

        //Imprimiendo Curriculum
        Persona persona = new Persona("123", "Pablo", "Magnin");
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add(".Net");
        habilidades.add("java");
        habilidades.add("pyhton");
        Documento curriculum = new Curriculum(persona, habilidades);
        Imprimible.imprimirDocumento(curriculum);

        //Imprimiendo Libro PDF
        Documento libroPDF = new LibroPDF("The Notebook", "Nicholas Sparks", "Romance", 185);
        Imprimible.imprimirDocumento(libroPDF);

        //Imprimiendo Informe
        Documento informe = new Informe("Informe de desempeño", "Evaluador", "Coach", 10);
        Imprimible.imprimirDocumento(informe);
    }
}
