package porTipo;

public class SerieDeInteger extends Prototipo<Integer> {


    public SerieDeInteger(Integer valorInicial, Integer secuencia) {
        super(valorInicial, secuencia);
    }

    @Override
    public Integer siguienteSerieProgresiva() {
        valorActual= valorActual+secuencia;
        return valorActual;
    }

    @Override
    public void setearInicioSerie(Integer nuevoValor) {

            valorInicial = nuevoValor;
            valorActual = valorInicial;

    }
}
