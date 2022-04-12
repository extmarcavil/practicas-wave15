package EjercicioPracticoClasesAbstractasEInterfaces.Animales.ImprimirDocumentos;

public class LibroPDF implements Imprimible{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Cant Paginas: " + cantidadPaginas + ", nombre: " + nombreAutor + ", titulo: " + titulo + "genero: " + genero);
    }
}
