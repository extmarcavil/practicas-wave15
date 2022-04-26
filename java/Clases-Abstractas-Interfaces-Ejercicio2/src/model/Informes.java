package model;

public class Informes extends Documento{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;


    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
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
    public String toString() {
        return "Informe: {" +
                "\nTexto='" + texto + '\'' +
                "\nCantidad de Paginas=" + cantidadPaginas +
                "\nAutor='" + autor + '\'' +
                "\nRevisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public String imprimir() {
        return this.toString();
    }
}
