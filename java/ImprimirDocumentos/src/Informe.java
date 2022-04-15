public class Informe implements Imprimir{

    private String texto;
    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {

        System.out.println("Autor: " + autor + ". Revisor: " + revisor + ". Cantida de páginas: " + cantidadDePaginas +
                ". Contenido: " + texto);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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
