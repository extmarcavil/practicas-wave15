package IntegradoresP1.SeriesNumericas;

public class Serie2 extends Prototipo<Integer> {
    public Serie2(Integer nroInicial) {
        super(nroInicial);
    }

    @Override
    public Integer getSiguienteValor() {
        Integer newValue = getNroSerieActual() + 2;
        setNroSerieActual(newValue);
        return newValue;
    }
}
