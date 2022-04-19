package integrador1_b;

public class DeADos extends Serie{
    public DeADos(Number inicial) {
        super(inicial);
    }

    public DeADos(Integer inicial){
        super(inicial);
    }

    public DeADos(Double inicial){
        super(inicial);
    }

    @Override
    public Number increment() {
        actual = actual.doubleValue() + 2;

        return actual;
    }
}
