package ejercicioDakar;

public abstract class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public double calcularResultado() {
        return (this.velocidad * this.aceleracion / 2) / (this.anguloDeGiro * (this.peso - this.ruedas * 100));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                "}\n";
    }
}
