package ejercicioSeriesNumericas;

public class SerieEnteros extends Prototipo<Integer>{

    public SerieEnteros(Integer valorSerie) {
        super(valorSerie);
        this.valorActual = 0;
    }

    @Override
    public Integer siguienteValor() {
        return valorActual += valorSerie;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0;
    }
}
