package ejercicioDocumentos;

public class Informe extends Documento {

    private String texto;
    private String autor;
    private String revisor;
    private int cantPaginas;

    public Informe(String texto, String autor, String revisor, int cantPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }
}
