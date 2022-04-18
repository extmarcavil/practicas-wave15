package model;

public class Auto extends Vehiculo{

    public Auto(Double velocidad,Double aceleracion,Double AnguloDeGiro,String patente) {
        this.peso = 1000;
        this.rueda = 4;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = AnguloDeGiro;
        this.patente = patente;
    }


}
