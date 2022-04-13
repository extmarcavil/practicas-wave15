package ejercicioSeriesNumericas;

public class SerieDouble extends Prototipo<Double>{
    public SerieDouble(Double valorSerie) {
        super(valorSerie);
        this.valorActual = 0.0;
    }

    @Override
    public Double siguienteValor() {
        return valorActual += valorSerie;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0.0;
    }
}
