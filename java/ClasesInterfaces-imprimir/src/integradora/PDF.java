package integradora;

public class PDF extends Persona implements Imprimible{

    int cantidadPaginas;
    String titulo;
    String genero;

    public PDF(String nombre, int cantidadPaginas, String titulo, String genero) {
        super(nombre);
        this.cantidadPaginas = cantidadPaginas;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
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
        System.out.println("---PDF---");
        System.out.println("Cantidad de páginas: ");
        System.out.println(getCantidadPaginas());
        System.out.println("Autor-> Nombre: " + getNombre());
        System.out.println("Titulo: ");
        System.out.println(getTitulo());
        System.out.println("Género: ");
        System.out.println(getGenero());
    }
}
