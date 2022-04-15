public class LibrosPdf implements Imprimir{

    private Integer cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPdf(Integer cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {

        System.out.println("Titulo: " + titulo + ". Autor/a: " + autor + ". Género: " + genero + ". Cantidad de páginas: " + cantidadDePaginas);
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
