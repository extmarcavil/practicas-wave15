package ejercicio2;

public class Informes implements Imprimible {

    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(int longitud, int cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el informe de texto con longitud " + longitud +
                ", son en total " + cantidadPaginas + " páginas, su autor es " + autor +
                " y su revisor es " + revisor);
    }
}
