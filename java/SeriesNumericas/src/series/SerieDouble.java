package series;

public class SerieDouble extends Serie<Double> {

    public SerieDouble(Double aumento) {
        this.aumento = aumento;
    }

    @Override
    public Double siguienteValor() {
        return valor += aumento;
    }
}
