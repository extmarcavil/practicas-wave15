package ejercicio2;

public class LibroPDF implements Imprimir{

    public int cantPaginas;
    public String nombAutor;
    public String titulo;
    public String genero;

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantPaginas=" + cantPaginas +
                ", nombAutor='" + nombAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(cantPaginas + " " + nombAutor + " " + titulo + " " + genero);
    }
}
