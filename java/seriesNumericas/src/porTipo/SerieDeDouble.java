package porTipo;

public class SerieDeDouble extends Prototipo<Double> {

    public SerieDeDouble(Double valorInicial, Double secuencia) {
        super(valorInicial, secuencia);
    }

    @Override
    public Double siguienteSerieProgresiva() {
        valorActual= valorActual.doubleValue()+secuencia.doubleValue();
        return valorActual;
    }

    @Override
    public void setearInicioSerie(Double nuevoValor) {

            valorInicial = nuevoValor;
            valorActual = valorInicial;

    }


}
