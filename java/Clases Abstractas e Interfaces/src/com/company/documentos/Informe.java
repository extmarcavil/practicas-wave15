package com.company.documentos;

public class Informe implements Imprimible{

    private Persona revisor;
    private Persona autor;
    private int cantidadPaginas;
    private String texto;

    public Informe(Persona revisor, Persona autor, int cantidadPaginas, String texto) {
        this.revisor = revisor;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.texto = texto;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "revisor=" + revisor +
                ", autor=" + autor +
                ", cantidadPaginas=" + cantidadPaginas +
                ", texto='" + texto + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir");
    }
}
