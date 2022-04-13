package porTipo;

public abstract class Prototipo <T extends Number>{
    protected T valorActual;
    protected T secuencia;
    protected T valorInicial;


    public Prototipo(T valorActual, T secuencia) {
        this.valorActual = valorActual;
        this.secuencia = secuencia;
        this.valorInicial = valorActual;
    }



    public abstract T siguienteSerieProgresiva();
    public void reiniciarSerieProgresiva(){
        valorActual = valorInicial;
    }
    public abstract void setearInicioSerie(T nuevoValor) ;
}
