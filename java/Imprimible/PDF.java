package Imprimible;

public class PDF extends Documento {
    private int cantidadPaginas;
    private String nombre;
    private String titulo;
    private  String genero;

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public PDF(int cantidadPaginas, String nombre, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombre = nombre;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "PDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
