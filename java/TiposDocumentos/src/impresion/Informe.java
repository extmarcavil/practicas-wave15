package impresion;

public class Informe implements Impresion {

    private String texto;
    private int cantPag;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPag, String autor, String revisor) {
        this.texto = texto;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void mostrar() {
        String impresion = "Autor: " + autor + "\tRevisor: " + revisor + "\tCantidad de paginas: " + cantPag + "\n" +
                           "Texto\n" + texto;
        System.out.println(impresion);
    }
}
