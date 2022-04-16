public abstract class Prototipo <T extends Number>{

    private T inicial;
    private T actual;


    public abstract T valorSiguiente();

    public void reiniciarSerie(){

        actual = inicial;
    }

    public void valorInicial(T inicial){

        this.inicial = inicial;
    }

    public T getInicial() {
        return inicial;
    }

    public void setInicial(T inicial) {
        this.inicial = inicial;
    }

    public T getActual() {
        return actual;
    }

    public void setActual(T actual) {
        this.actual = actual;
    }
}
