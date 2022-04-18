package Clases;

public class Serie extends Prototipo{

    private int initNum;
    private int serie;
    private int valor;

    public Serie(int serie, int initNum) {
        this.serie = serie;
        this.initNum = initNum;
        this.valor = initNum;
    }

    @Override
    public int siguienteValor() {
        valor = valor + serie;
        return valor;
    }

    @Override
    public void reiniciarValor() {
        valor = initNum;
    }

    @Override
    public void setValor(int value) {
        valor = value;
    }
}
