package Main;

import Clases.Curriculum;
import Clases.Informe;
import Clases.Libro;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro(300, "Klaus", "Como Ganar", "Motivacional" );
        libro.Imprimir();
        String[] array = { "Tomar Fotos", "Patinar", "Andar en Moto"};
        Curriculum cv = new Curriculum("Klaus", 35, "Ing En Sistemas", array);
        cv.Imprimir();
        Informe informe = new Informe(300, "Klaus", "Meli", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." );
        informe.Imprimir();
    }
}
