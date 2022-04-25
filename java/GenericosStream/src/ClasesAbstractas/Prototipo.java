package ClasesAbstractas;

public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T cuenta;
    protected T step;

    abstract public T valorSiguiente();
    abstract public void reiniciarCuenta();
    abstract public void setValorInicial(T nuevoValor);

}
