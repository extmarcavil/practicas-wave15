public abstract class Prototipo {
    private Number incremento;
    private Number valorInicial;
    private Number ultimoValor;
    private boolean primeraVez = true;

    public Prototipo(Number valorSerie) {
        this.incremento = valorSerie;
        valorInicial = 0;
    }

    public Number valorSiguiente() {
        if(primeraVez) {
            primeraVez = false;
            ultimoValor = valorInicial;
            return ultimoValor;
        }
        if(ultimoValor instanceof Double)
            return ultimoValor.doubleValue() + incremento.doubleValue();
        if(ultimoValor instanceof Integer)
            return ultimoValor.intValue() + incremento.intValue();
        if(ultimoValor instanceof Float)
            return ultimoValor.floatValue() + incremento.floatValue();
        if(ultimoValor instanceof Short)
            return ultimoValor.shortValue() + incremento.shortValue();
        if(ultimoValor instanceof Long)
            return ultimoValor.longValue() + incremento.longValue();

        return ultimoValor.byteValue() + incremento.byteValue();
    }

    public void valorInicial(Number inicial) {
        valorInicial = inicial;
    }
    public void reiniciarSerie() {
        ultimoValor = valorInicial;
        primeraVez = true;
    }
}
