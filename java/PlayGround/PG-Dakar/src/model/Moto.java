package model;

public class Moto extends Vehiculo {

    public Moto(Double velocidad,Double aceleracion,Double AnguloDeGiro,String patente) {
        this.peso = 300;
        this.rueda = 2;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = AnguloDeGiro;
        this.patente = patente;
    }
}
