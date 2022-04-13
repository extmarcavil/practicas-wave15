package SeriesNumericas;

public class Flotante extends Generico<Float>{

    public Flotante(Float inicio) {
        super(inicio);
        numero=0f;
    }

    @Override
    public Float siguienteValor() {
        return numero+=inicio;
    }

    @Override
    public void reiniciarSerie() {
        numero=0f;
    }
}
