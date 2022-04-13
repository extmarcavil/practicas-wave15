package SeriesNumericas;

public class Doubles extends Generico<Double>{
    public Doubles(Double inicio) {
        super(inicio);
        numero=0.0;
    }

    @Override
    public Double siguienteValor() {
        return numero+=inicio;
    }

    @Override
    public void reiniciarSerie() {
        numero=0.0;
    }
}
