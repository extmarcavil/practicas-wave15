package integrador1_b;

public class PrototipoDouble extends Serie<Double>{
    private double incremental;

    public PrototipoDouble(Double inicial, double incremental) {
        super(inicial);
        this.incremental = incremental;
    }

    @Override
    public Double increment() {
        actual = actual.doubleValue() + incremental;
        return actual;
    }
}
