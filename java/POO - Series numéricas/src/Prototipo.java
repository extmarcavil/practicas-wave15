public abstract class Prototipo<T extends Number>{

    private T valorInicial;
    private T valorActual;

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract T calcularValorSiguiente();

    public void reiniciarSerie(){
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T numero){
        this.valorInicial = numero;
        this.valorActual = numero;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
}
