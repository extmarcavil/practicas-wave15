package IntegradoresP1.SeriesNumericas;

public abstract class Prototipo <T> {
    private T nroInicial;
    private T nroSerieActual;

    public Prototipo(T nroInicial) {
        this.nroInicial = nroInicial;
        this.nroSerieActual = nroInicial;
    }

    public T getNroInicial() { return nroInicial; }

    public void setNroInicial(T nroInicial) {
        this.nroInicial = nroInicial;
        this.nroSerieActual = nroInicial;
    }

    public T getNroSerieActual() {
        return nroSerieActual;
    }

    public void setNroSerieActual(T nroSerieActual) {
        this.nroSerieActual = nroSerieActual;
    }

    public abstract T getSiguienteValor();

    public void reiniciarSerie(){
        nroSerieActual = nroInicial;
        System.out.println("Serie reiniciada.");
    }

    public void setValorInicial(T nroInicial){
        this.nroInicial = nroInicial;
        this.nroSerieActual = nroInicial;
    }
}
