package Ejercicio2;

public class Libro implements Imprimible{

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    private String autor, titulo, genero;
    private int cant_paginas;

    public Libro(String autor, String titulo, String genero, int cant_paginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cant_paginas = cant_paginas;
    }

    @Override
    public void imprimible() {
        System.out.println("Autor: " + autor + "\t Titulo: " + titulo + "\t Genero: " + genero +
                "\t Cantidad de paginas: " + cant_paginas);
    }
}
