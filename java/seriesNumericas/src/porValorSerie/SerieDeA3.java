package porValorSerie;

public class SerieDeA3 extends Prototipo{


    public SerieDeA3(Number valorInicial) {
        super(valorInicial, 3);
    }

    @Override
    public Number siguienteSerieProgresiva() {
        valorActual= valorActual.doubleValue()+secuencia.doubleValue();
        return valorActual;
    }
}
