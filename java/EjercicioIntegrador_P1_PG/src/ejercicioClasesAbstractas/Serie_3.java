package ejercicioClasesAbstractas;

public class Serie_3 extends  Prototipo <Integer>{

    private int n=0;
    private int n0=0;
    private int cont=0;

    @Override
    public int nMasUno() {
        n = 3 + n;
        return  n;
    }
    @Override
    public void reiniciarSeri() {
        n=n0;
        cont = 0;
    }

    @Override
    public void establecerValorInicial(Integer inicial) {
        n0 = inicial;
        n = n0;
    }

    public double valorN (){
        cont++;
        if (cont <= 1 ) {
            return n0;
        }else {return nMasUno();}

    }
}
