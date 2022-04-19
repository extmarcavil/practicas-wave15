package com.company;

public class Pdf {

    private int cantidad;
    private int paginas;
    private String nombre;
    private String autor;
    private String genero;

    public Pdf(int cantidad, int paginas, String nombre, String autor, String genero) {
        this.cantidad = cantidad;
        this.paginas = paginas;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pdf{" +
                "cantidad=" + cantidad +
                ", paginas=" + paginas +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }


}
