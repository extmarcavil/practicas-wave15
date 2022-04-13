package ejercicioDocumentos;

public class LibroPDF extends Documento {
    private String titulo;
    private String autor;
    private String genero;
    private int cantPaginas;

    public LibroPDF(String titulo, String autor, String genero, int cantPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", cantPaginas='" + cantPaginas + '\'' +
                '}';
    }
}
