package abstractCalssExcercise;

public abstract class Prototipo<T extends Number> {

    private T number;
    private T init;

    public Prototipo(T number) {
        this.number = number;
        this.init = number;
    }

    public abstract Number nextValue();

    public abstract void restart();

    public void initValue(T value) {
        this.number = value;
    }
}
