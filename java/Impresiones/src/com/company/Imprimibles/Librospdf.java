package com.company.Imprimibles;

import com.company.Imprimir;

public class Librospdf implements Imprimir {

    private String titulo;
    private int cantidadPaginas;
    private String autor;
    private String genero;

    public Librospdf(String titulo, int cantidadPaginas, String autor, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Librospdf{" +
                "titulo='" + titulo + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Este es el libro");
        System.out.println(this);
    }
}
