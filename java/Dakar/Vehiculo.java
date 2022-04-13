package Dakar;

public abstract class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer cantidadDeRuedas;


    public Vehiculo () { }

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer cantidadDeRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public double obtenerValor() {
        return (velocidad * 0.5 * aceleracion) / (anguloDeGiro * (peso - cantidadDeRuedas*100));
    }

    public String getPatente() {
        return patente;
    }
}
