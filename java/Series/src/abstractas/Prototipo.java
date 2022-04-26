package abstractas;

public abstract class Prototipo<T extends Number> {

    private T inicio;
    private final T aumento;
    private double actual;

    public Prototipo(T aumento){
        this.aumento = aumento;
    }

    public double siguiente(){
        actual = actual + aumento.doubleValue();
        System.out.println(actual);
        return  actual;
    }

    public void reiniciar(){
        actual = inicio.doubleValue();
    }

    public void setInicio(T inicio){
        this.inicio = inicio;
        reiniciar();
    }
}
