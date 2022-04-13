package impresionDocumentos;

public class Informe implements Imprimible{

    private int cantidadPaginas;
    private String autor;
    private String texto;
    private String revisor;

    public Informe(int cantidadPaginas, String autor, String texto, String revisor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.texto = texto;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
        System.out.println("Texto:" + texto + ". Autor: " + autor + ". Revisor: " + revisor + ". Cantidad de paginas: " + cantidadPaginas);
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}