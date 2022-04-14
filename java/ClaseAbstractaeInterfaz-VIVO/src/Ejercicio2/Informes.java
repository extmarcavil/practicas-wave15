package Ejercicio2;

public class Informes implements Imprimible {
    private int longitud, cant_paginas;
    private String autor, revisor;

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
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

    public Informes(int longitud, int cant_paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cant_paginas = cant_paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimible() {
        System.out.println("Autor: " + autor + "\t Revisor: " + revisor + "\t Longitud:  " + longitud +
                "\t Cantidad de paginas: " + cant_paginas);
    }
}
