package TutorialBootcamp.POO;

public class Libro {
    String Titulo;
    String Autor;
    int ejemplares;


    public Libro(String titulo, String autor, int ejemplares) {
        this.Titulo = titulo;
        this.Autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadDeEjemplares(){
        return ejemplares;
    }

    public String MostrarLibro(){
        return " Titulo: " + Titulo+ ", Autor: " + Autor + ", Ejemplares: " + ejemplares;
    }
}
