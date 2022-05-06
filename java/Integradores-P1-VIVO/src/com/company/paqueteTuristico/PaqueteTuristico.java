package com.company.paqueteTuristico;

public abstract class PaqueteTuristico {

    /**
     * Atributos
     */
    public String nombreDeLaReserva;
    public int numeroDeReservas;

    /**
     * Constructor
     */
    public PaqueteTuristico(String nombreDeLaReserva) {
        this.nombreDeLaReserva = nombreDeLaReserva;
        this.numeroDeReservas = 1;
    }

    /**
     * Metodos
     */
    public abstract double calcularPrecioDeReserva();

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "nombreDeLaReserva='" + nombreDeLaReserva + '\'' +
                ", numeroDeReservas=" + numeroDeReservas +
                '}';
    }


    /**
     * Getter & Setter
     */
    public String getNombreDeLaReserva() {
        return nombreDeLaReserva;
    }

    public int getNumeroDeReservas() {
        return numeroDeReservas;
    }

    public void setNumeroDeReservas(int numeroDeReservas) {
        this.numeroDeReservas = numeroDeReservas;
    }


}
