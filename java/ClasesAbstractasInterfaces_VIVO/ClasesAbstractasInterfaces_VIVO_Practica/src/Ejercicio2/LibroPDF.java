package Ejercicio2;

import javax.print.Doc;

public class LibroPDF extends Documento {

    int cantidadPaginas;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public void imprimirDocumento() {
        System.out.println("---LIBRO PDF---\n" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'');
    }
}
