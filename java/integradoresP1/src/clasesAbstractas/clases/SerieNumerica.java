package clasesAbstractas.clases;

public abstract class SerieNumerica <T extends Number> {

    protected T actual;
    protected T inicial;

    public SerieNumerica(T inicial) {
        this.inicial = inicial;
    }

    public abstract T next();

    public abstract void reset();

    public abstract void init(T inicial);



}
