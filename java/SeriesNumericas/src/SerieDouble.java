public class SerieDouble extends Prototipo<Double>{
    public SerieDouble(Double inicial) {
        super(inicial);
        this.actual = 0.0;
    }

    @Override
    public void reiniciarSerie() {
        actual = 0.0;
    }

    @Override
    public Double siguiente() {
        actual = actual + inicial;
        return actual;
    }
}
