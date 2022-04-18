package clasesAbstractas.clases;

public class SerieNumerica3 extends SerieNumerica<Integer>{

    public SerieNumerica3(Integer inicial) {
        super(inicial);
    }

    @Override
    public Integer next() {
        actual+=3;
        return actual;
    }

    @Override
    public void reset() {
        actual=inicial;
    }

    @Override
    public void init(Integer inicial) {
        super.inicial=inicial;
        actual=inicial;
    }
}
