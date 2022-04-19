package integrador1_b;

public class PrototipoInt extends Serie<Integer>{
    private int incremental;

    public PrototipoInt(Integer inicial, int incremental) {
        super(inicial);
        this.incremental = incremental;
    }

    @Override
    public Integer increment() {
        actual = actual.intValue() + incremental;
        return actual;
    }
}
