package integrador1_b;

public class DeATres extends Serie{
    public DeATres(Number inicial) {
        super(inicial);
    }

    @Override
    public Number increment() {
        actual = actual.intValue() + 3;

        return actual;
    }
}
