package clasesAbstractas.clases;

public class SerieNumerica2 extends SerieNumerica<Integer> {

    public SerieNumerica2(Integer inicial) {
        super(inicial);
    }

    @Override
    public Integer next() {
         actual+=2;
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
