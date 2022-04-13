public abstract class Prototipo <T extends Number>{

    protected T inicial;
    protected T actual;

    public Prototipo(T inicial) {
        this.inicial = inicial;
    }


    public abstract void reiniciarSerie();

    public void iniciarSerie(T inicial){
        this.actual = inicial;
    }

    public abstract T siguiente();






    
}
