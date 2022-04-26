import interfaces.Imprimible;
import models.Curriculum;
import models.Informe;
import models.Libro;

public class Main {
    public static void main(String[] args) {
        Imprimible generico;
        Libro libro = new Libro(300, "Stephen King", "IT", "Terror" );
        generico = libro;
        generico.Imprimir();
        String[] habilidades = { "Desarrollo", "Abstracción", "Razonamiento"};
        Curriculum cv = new Curriculum("Luis David", 25, "Ing En TIC", habilidades);
        generico = cv;
        generico.Imprimir();
        Informe informe = new Informe(300, "Alfredo", "Meli", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." );
        generico = informe;
        generico.Imprimir();
    }
}
