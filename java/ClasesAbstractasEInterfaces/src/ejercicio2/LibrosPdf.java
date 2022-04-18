package ejercicio2;

public class LibrosPdf implements Imprimible {

    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPdf(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiento Libro PDF: " + titulo + " - " +
                autor + ", de " + cantidadDePaginas + " páginas y su género es " + genero);
    }
}
