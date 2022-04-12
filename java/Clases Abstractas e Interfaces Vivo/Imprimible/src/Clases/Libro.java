package Clases;

import Interfaces.Imprimible;

public class Libro implements Imprimible {
    int cantidadDePaginas;
    String autor;
    String titulo;
    String genero;

    public Libro(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void Imprimir() {
        System.out.println("Autor: " + this.autor);
        System.out.println("Cantidad de Paginas: " + this.cantidadDePaginas);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Género: " + this.genero);
    }
}
