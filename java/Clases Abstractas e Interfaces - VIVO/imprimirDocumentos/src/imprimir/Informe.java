package imprimir;

public class Informe implements Imprimible{
    private int cantPaginas;
    private String autor;
    private String revisor;
    private String texto;

    @Override
    public void imprimir() {
        System.out.println("Cantidad de paginas: " + cantPaginas + ", autor: " + autor + ", revisor: " + revisor + ", texto: " + texto);
    }
}
