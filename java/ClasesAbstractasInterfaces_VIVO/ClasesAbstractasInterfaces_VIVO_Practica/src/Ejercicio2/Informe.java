package Ejercicio2;

public class Informe extends Documento{
    int nLongitudTexto;
    int nPaginas;
    String autor;
    String revisor;

    public Informe(int nLongitudTexto, int nPaginas, String autor, String revisor) {
        this.nLongitudTexto = nLongitudTexto;
        this.nPaginas = nPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimirDocumento() {
        System.out.println("---Informe---\n" +
                "nLongitudTexto=" + nLongitudTexto +
                ", nPaginas=" + nPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'');
    }
}
