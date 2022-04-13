package seriesNumericas;

public class Serie2 extends Prototipo{

    private int valor;
    private int valorIni;
    private int valorSalto;

    public Serie2(int valorSalto) {
        this.valorSalto = valorSalto;
        valor = 0;
        valorIni = 0;
    }

    @Override
    public int valorSiguiente() {
        valor = valor + valorSalto;
        return valor;
    }

    @Override
    public void reiniciar() {
        valor = valorIni;
    }

    @Override
    public void establecerInicio(int i) {
        valorIni = i;
        reiniciar();
    }
}
