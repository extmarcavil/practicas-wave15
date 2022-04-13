package SeriesNumericas;

public abstract class Generico<T extends Number> {
    protected T numero;
    protected T inicio;

    public Generico(T inicio) {
        this.inicio = inicio;
    }
    public abstract T siguienteValor();
    public abstract void reiniciarSerie();
    public void iniciarSerie(T valorInicial){
        inicio=valorInicial;
    }


    public T getInicio() {
        return inicio;
    }

    public void setInicio(T inicio) {
        this.inicio = inicio;
    }

    public T getNumero() {
        return numero;
    }

    public void setNumero(T numero) {
        this.numero = numero;
    }



}

