package ejercicioSeriesNumericas;

public abstract class Prototipo <T extends Number> {
    protected T valorSerie;
    protected T valorActual;

    public Prototipo(T valorSerie) {
        this.valorSerie = valorSerie;
    }

    public abstract T siguienteValor();

    public abstract void reiniciarSerie();

    public void iniciarSerie(T valorInicial) {
        this.valorActual = valorInicial;
    }

}
