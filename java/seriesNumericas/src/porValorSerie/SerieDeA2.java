package porValorSerie;

public class SerieDeA2 extends Prototipo{

    public SerieDeA2(Number valorInicial) {
        super(valorInicial, 2);
    }

    @Override
    public Number siguienteSerieProgresiva() {
        valorActual= valorActual.doubleValue()+secuencia.doubleValue();
        return valorActual;
    }



}
