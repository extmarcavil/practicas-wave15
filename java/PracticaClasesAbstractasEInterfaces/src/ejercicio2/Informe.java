package ejercicio2;

public class Informe implements Imprimir{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("El informe creado por " + autor + " tiene " + texto.length() + " caracteres, tiene "
                + cantidadPaginas + " paginas y su revisor es" + revisor);
    }
}
