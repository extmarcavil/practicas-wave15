package SeriesNumericas;

public class Int extends Generico<Integer>{

    public Int(Integer inicio) {
        super(inicio);
        numero=0;
    }

    @Override
    public Integer siguienteValor() {
        return numero+=inicio;
    }

    @Override
    public void reiniciarSerie() {
        numero=0;
    }
}
