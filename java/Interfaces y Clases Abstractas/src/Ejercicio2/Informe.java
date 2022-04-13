package Ejercicio2;

public class Informe implements TipoDocumento {

    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
}
