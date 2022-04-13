package series;

public abstract class Serie<T extends Number> {

    private T valorInicial;
    protected T aumento;
    protected T valor;

    public abstract T siguienteValor();

    public void reiniciarSerie() {
        valor = valorInicial;
    }

    public void establecerInicio(T valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }
}
