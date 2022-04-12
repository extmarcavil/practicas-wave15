package TutorialBootcamp;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro("Harry Potter", "J. K. Rowling", 20);
        System.out.println(libro.MostrarLibro());
        System.out.println("La cantidad de libros es de: "+ libro.cantidadDeEjemplares());
    }
}
