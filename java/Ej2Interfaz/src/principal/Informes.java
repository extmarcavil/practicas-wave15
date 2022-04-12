package principal;

public class Informes implements Imprimir {

        /*Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
    Representar un escenario donde se creen cada uno de estos objetos y que,
    por medio de un método estático de una interfaz imprimible,
    se pueda pasar cualquier tipo de documento y sea impreso el contenido.
    */

    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
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
    public String imprimirDoc() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
