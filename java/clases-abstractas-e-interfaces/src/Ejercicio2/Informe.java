package Ejercicio2;

public class Informe extends Documento {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String mostrarTipoDocumento() {
        return "Informe";
    }

    @Override
    public String imprimirContenido() {
        return "Autor: " + autor + "\nRevisor: " + revisor + "\nPaginas: " + cantidadPaginas + "\nContenido: " + texto;
    }
}
