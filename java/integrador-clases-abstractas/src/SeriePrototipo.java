public abstract class SeriePrototipo<T extends Number> {
    private T valorInicial;
    private T valorActual;
    private T incremento;

    public SeriePrototipo(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        valorActual = this.valorInicial;
        this.incremento = incremento;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public T getIncremento() {
        return incremento;
    }

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    private Number sumarT() {
        if (valorActual instanceof Integer) {
            return Integer.sum(valorActual.intValue(), incremento.intValue());
        } else if (valorActual instanceof Long) {
            return Long.sum(valorActual.longValue(), incremento.longValue());
        } else if (valorActual instanceof Double) {
            return Double.sum(valorActual.doubleValue(), incremento.doubleValue());
        } else if (valorActual instanceof Float) {
            return Float.sum(valorActual.floatValue(), incremento.floatValue());
        } else {
            return valorInicial;
        }
    }

    public T proximoNumero() {
        T siguiente = (T) sumarT();
        valorActual = siguiente;
        return siguiente;
    }

}
