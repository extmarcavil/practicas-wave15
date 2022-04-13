package com.company;

public class Informe implements Imprimir{
    String texto;
    int longitud;
    int paginas;
    String autor;
    String revisor;

    public Informe(String texto, int longitud, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", longitud=" + longitud +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }
}
