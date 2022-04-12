package Clases;

import Interfaces.Imprimible;

public class Informe implements Imprimible {
    int cantidadDePaginas;
    String autor;
    String revisor;
    String texto;

    public Informe(int cantidadDePaginas, String autor, String revisor, String texto) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    @Override
    public void Imprimir() {
        System.out.println("Autor: " + this.autor);
        System.out.println("Cantidad de Paginas: " + this.cantidadDePaginas);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Texto: " + this.texto);
    }
}
