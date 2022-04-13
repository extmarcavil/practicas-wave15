package main;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> listaHabilidades = new ArrayList<>();
        listaHabilidades.add("Software Developer");
        listaHabilidades.add("Licenciado en Turismo");
        Curriculum cv1 = new Curriculum("Gonzalo", "Murias", 28, "Olivos, Buenos Aires", listaHabilidades);
        cv1.imprimir();

        System.out.println("-------");

        LibroEnPdf libro1 = new LibroEnPdf(96, "Antoine de Saint-Exupéry", "El Principito", "Novela Corta");
        libro1.imprimir();

        System.out.println("-------");

        Informe informe1 = new Informe("Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.", 200, "Desconocido", "Desconocido");
        informe1.imprimir();


    }
}
