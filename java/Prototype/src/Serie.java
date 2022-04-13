public class Serie extends Prototipo {
    private final Number startSerieOf;
    private Number next;

    public Serie(Number serieOf) {
        this.startSerieOf = serieOf;
        this.next = serieOf;
    }

    @Override
    public Number next() {
        Number ret = next;
        next = ret.doubleValue() + startSerieOf.doubleValue();
        return ret;
    }

    @Override
    public void reset() {
        this.next = startSerieOf;
    }

    @Override
    public void setBase(Number number) {
        this.reset();
        this.next = number;
    }
}
