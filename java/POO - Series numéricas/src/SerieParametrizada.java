public class SerieParametrizada extends Prototipo{

    Number numero;

    public Number getNumero() {
        return numero;
    }

    public void setNumero(Number numero) {
        this.numero = numero;
    }

    public SerieParametrizada(Number valorInicial, Number numero) {
        super(valorInicial);
        this.numero = numero;
    }

    @Override
    public Number calcularValorSiguiente() {
        Number siguiente = this.getValorActual().doubleValue()+ numero.doubleValue();
        this.setValorActual(siguiente);
        return getValorActual();
    }
}
