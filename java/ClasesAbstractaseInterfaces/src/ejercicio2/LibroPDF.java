package ejercicio2;

public class LibroPDF implements Imprimible{

    int cantidadDePaginas;
    String nombreautor;
    String titulo;
    String genero;

    @Override
    public void imprimir() {
        System.out.println("Titulo: el principito");
        System.out.println("Nombre del autor: No recuerdo");
        System.out.println("Genero: - ");
        System.out.println("Cantidad de Paginas: -");

    }
}
