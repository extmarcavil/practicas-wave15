public abstract class Prototipo <T extends Number>{


    T valorInicial;
    T numSerie;
    T cantidad;

    public Prototipo(T valorInicial, T numSerie, T cantidad) {
        setCantidad(cantidad);
        setNumSerie(numSerie);
        setValorInicial(valorInicial);
    }

    public T getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(T numSerie) {
        this.numSerie = numSerie;
    }

    public T getCantidad() {
        return cantidad;
    }

    public void setCantidad(T cantidad) {
        this.cantidad = cantidad;
    }

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    // methods

    public abstract  void devolverSiguiente( T  valorInicial,  T numSerie, T cantidad);

    public  <T extends Number> Double obtenerValorInicial(T valorInicial){
        double valorI = valorInicial.doubleValue();
        return valorI;
    }

    public abstract void reiniciar();

}
