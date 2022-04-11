public class LibrosPDF implements Imprimir {
    private  int CantidadPaginas;

    private  String NombreAutor;

    private String Titulo;

    private  String Genero;

    public LibrosPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        CantidadPaginas = cantidadPaginas;
        NombreAutor = nombreAutor;
        Titulo = titulo;
        Genero = genero;
    }

    @Override
    public void ImprimirPantalla() {
        System.out.println("La informaciòn del libro es \n" +
                "Autor: " + this.NombreAutor + "\n" +
                "Titulo: " + this.Titulo + "\n" +
                "Genero: " + this.Genero + "\n" +
                "Cantidad de Pàginas: " + this.CantidadPaginas + "\n");
    }
}
