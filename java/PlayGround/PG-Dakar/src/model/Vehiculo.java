package model;

public class Vehiculo {

    protected Double velocidad;
    protected Double aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Integer peso;
    protected Short rueda;


    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Short getRueda() {
        return rueda;
    }

    public void setRueda(Short rueda) {
        this.rueda = rueda;
    }

    public String getPatente() {
        return patente;
    }
}

