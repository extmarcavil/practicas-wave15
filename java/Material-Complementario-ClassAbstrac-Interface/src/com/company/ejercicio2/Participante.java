package com.company.ejercicio2;

import com.company.ejercicio2.nave.FlotaDeNaves;
import com.company.ejercicio2.nave.Nave;

public class Participante {

    /**
     * Atributos
     */
    private Nave naveSimple;
    private FlotaDeNaves flotaDeNaves;
    private int puntuacion;

    /**
     * Constructor
     */
    public Participante(Nave naveSimple) {
        this.naveSimple = naveSimple;
        this.puntuacion = 0;
    }

    public Participante(FlotaDeNaves flotaDeNaves, int puntuacion) {
        this.flotaDeNaves = flotaDeNaves;
        this.puntuacion = 0;
    }

    /**
     * Getter & Setter
     *
     * @return
     */
    public Nave getNaveSimple() {
        return naveSimple;
    }

    public void setNaveSimple(Nave naveSimple) {
        this.naveSimple = naveSimple;
    }

    public FlotaDeNaves getFlotaDeNaves() {
        return flotaDeNaves;
    }

    public void setFlotaDeNaves(FlotaDeNaves flotaDeNaves) {
        this.flotaDeNaves = flotaDeNaves;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
