package com.company;

public class Informes {

    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
