package modelo;

public class Vehiculo {

    protected Double velocidad;
    protected Double aceleracion;
    protected Double anguloGiro;
    protected String patente;
    protected Double peso;
    protected Integer ruedas;


    public Vehiculo() {
    }

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
    }

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

    public Double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(Double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
