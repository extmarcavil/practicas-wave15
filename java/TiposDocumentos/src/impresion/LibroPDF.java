package impresion;

public class LibroPDF implements Impresion {

    private String autor;
    private String titulo;
    private String genero;
    private int cantPag;
    private String contenido;

    public LibroPDF(String autor, String titulo, String genero, int cantPag, String contenido) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantPag = cantPag;
        this.contenido = contenido;
    }

    @Override
    public void mostrar() {
        String impresion = "Autor: " + autor + "\tTitulo: " + titulo + "\tGenero: " + genero +
                            "\n" + contenido;
        System.out.println(impresion);
    }
}
