package ejercicio2;

public class LibroPDF implements Imprimible {
    int cantidadPaginas;
    String nombreAutor;
    String titulo;
    String genero;

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Cantidad de paginas: " + cantidadPaginas);
    }
}
