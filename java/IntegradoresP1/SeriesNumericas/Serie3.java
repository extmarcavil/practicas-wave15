package IntegradoresP1.SeriesNumericas;

public class Serie3 extends Prototipo<Double>{
    public Serie3(Double nroInicial) {
        super(nroInicial);
    }

    @Override
    public Double getSiguienteValor() {
        Double newValue = getNroSerieActual() + 3;
        setNroSerieActual(newValue);
        return newValue;
    }
}
