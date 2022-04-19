package ejercicioImpresora;

public class LibroPDF {
    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
