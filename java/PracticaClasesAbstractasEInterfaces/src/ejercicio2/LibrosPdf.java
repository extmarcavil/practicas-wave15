package ejercicio2;

public class LibrosPdf implements Imprimir{

    private  int catidadPaginas;
    private String nombreAutor;
    private  String titulo;
    private  String genero;

    public LibrosPdf(int catidadPaginas, String nombreAutor, String titulo, String genero) {
        this.catidadPaginas = catidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCatidadPaginas() {
        return catidadPaginas;
    }

    public void setCatidadPaginas(int catidadPaginas) {
        this.catidadPaginas = catidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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

    @Override
    public void imprimir() {
        System.out.println("El libro " + titulo + " del autor " + nombreAutor + " es de genero "
                + genero + " y tiene " + catidadPaginas + " paginas");
    }
}
