package porValorSerie;

public abstract class Prototipo <T extends Number>{
     T valorActual;
     T secuencia;
     T valorInicial;


    public T getSecuencia() {
        return secuencia;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Prototipo(T valorActual, T secuencia) {
        this.valorActual = valorActual;
        this.secuencia = secuencia;
        this.valorInicial = valorActual;
    }

    public void setSecuencia(T secuencia) {
        this.secuencia = secuencia;
    }


    public abstract T siguienteSerieProgresiva();
    public void reiniciarSerieProgresiva(){
        valorActual = valorInicial;
    }
    public void setearInicioSerie(T nuevoValor) {
        valorInicial = nuevoValor;
        valorActual = valorInicial;
    }
    public T valorInicialSerie(){
        return valorInicial;
    }
}
