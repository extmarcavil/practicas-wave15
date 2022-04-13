package ClasesAbstractasEInterfaces.Ej2.Clases;

public class Informe {

    private String autor;
    private String revisor;
    private String texto;
    private int cantidadPaginas;

    public Informe(String autor, String revisor, String texto, int cantidadPaginas){
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autor: ").append(getAutor()).append("\n");
        sb.append("Revisor: ").append(getRevisor()).append("\n");
        sb.append("Texto: ").append(getTexto()).append("\n");
        sb.append("Cantidad de paginas: ").append(getCantidadPaginas()).append("\n");
        return sb.toString();
    }
}
