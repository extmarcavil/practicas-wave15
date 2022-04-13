package impresionDocumentos;

public class LibroPDF implements Imprimible{

    private int cantidadPaginas;
    private String autor;
    private String genero;
    private String titulo;

    public LibroPDF(int cantidadPaginas, String autor, String genero, String titulo) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo PDF...");
        System.out.println("Titulo:" + titulo + ". Autor: " + autor + ". Genero: " + genero + ". Cantidad de paginas: " + cantidadPaginas);
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}