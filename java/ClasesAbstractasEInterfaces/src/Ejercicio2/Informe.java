package Ejercicio2;

public class Informe implements Imprimible {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimir() {
        System.out.println("Informe por " + autor + " revisor " + revisor + " cantidad de paginas " + cantidadPaginas + ".");
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
}
