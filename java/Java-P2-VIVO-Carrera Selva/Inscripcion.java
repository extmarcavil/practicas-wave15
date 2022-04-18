package com.company;

public class Inscripcion {
    public static int contador;
    private int nroInscripto;
    private Participante participante;
    private Categoria categoria;

    public Inscripcion(Participante participante, Categoria categoria) {
        this.nroInscripto = ++contador;
        this.participante = participante;
        this.categoria = categoria;
    }

    public int getNroInscripto(){
        return this.nroInscripto;
    }

    public Participante getParticipante(){
        return this.participante;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    @Override
    public String toString() {
        return " Nro de Inscripto : " + nroInscripto +
                ", participante : " + participante +
                ", categoria : " + categoria + '}';
    }
}
