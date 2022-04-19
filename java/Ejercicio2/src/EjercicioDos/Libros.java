package EjercicioDos;

public class Libros implements Imprimir{
    private String autor, genero, titulo;
    private int cantidad;

    public Libros(String autor, String genero, String titulo, int cantidad) {
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public String imprimir() {
        return toString();
    }
}
