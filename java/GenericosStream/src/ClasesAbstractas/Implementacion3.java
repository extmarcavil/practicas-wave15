package ClasesAbstractas;

public class Implementacion3<T extends Number> extends Prototipo{
    public Implementacion3() {
        step = 3;
        valorInicial = 0;
        cuenta = 0;
    }

    @Override
    public Number valorSiguiente() {
        this.cuenta = cuenta.doubleValue() + step.doubleValue();
        return this.cuenta;
    }

    @Override
    public void reiniciarCuenta() {
        cuenta = valorInicial;
    }

    @Override
    public void setValorInicial(Number nuevoValor) {
        valorInicial = nuevoValor;
    }
}
