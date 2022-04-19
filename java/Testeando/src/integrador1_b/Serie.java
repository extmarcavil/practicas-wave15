package integrador1_b;

public abstract class Serie <T extends Number> {
    T inicial;
    T actual;

    public Serie(T inicial) {
        this.inicial = inicial;
        this.actual = inicial;
    }

    public abstract T increment();

    public void reiniciar(){
        actual = inicial;
    }

    public void setInicial(T inicial){
        this.inicial = inicial;
        this.actual = inicial;
    }
}
