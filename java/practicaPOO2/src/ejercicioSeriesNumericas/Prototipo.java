package ejercicioSeriesNumericas;

public abstract class Prototipo<T extends Number> {
    private T valorInicial;
    private T valorSiguiente;
    private T incremento;

    public Prototipo() {
    }

    public Prototipo(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.valorSiguiente = valorInicial;
    }

    public abstract void crearSerie();
    public abstract void reiniciarSerie();
    public abstract void establecerValorInicial(T nro);

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getIncremento() {
        return incremento;
    }

    public void setIncremento(T incremento) {
        this.incremento = incremento;
    }

    public T getValorSiguiente() {
        return valorSiguiente;
    }

    public void setValorSiguiente(T valorSiguiente) {
        this.valorSiguiente = valorSiguiente;
    }
}
