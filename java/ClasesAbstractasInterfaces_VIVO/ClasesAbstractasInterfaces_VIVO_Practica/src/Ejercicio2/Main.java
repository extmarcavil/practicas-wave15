package Ejercicio2;

/*
Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.
Entre los tipos de documentos se encuentran:

Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido.
*/


public class Main {

    public static void main(String[] args) {

        Curriculum curri = new Curriculum("mauro", "hab1", "hab2","hab3","hab4");
        LibroPDF libro = new LibroPDF(1,"aurelio", "como cazar", "suspenso");
        Informe informe = new Informe(10,5, "marco", "arturo");

        curri.imprimirDocumento();
        libro.imprimirDocumento();
        informe.imprimirDocumento();





    }

}
