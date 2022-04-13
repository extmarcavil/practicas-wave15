package series;

public class SerieInteger extends Serie<Integer> {

    public SerieInteger(Integer aumento) {
        this.aumento = aumento;
    }

    @Override
    public Integer siguienteValor() {
        return valor += aumento;
    }
}
