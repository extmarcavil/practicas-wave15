package ejercicioClasesAbstractas;

public class Clase1 extends Prototipo <Integer>{

    private int n=0;
    private int n0=0;
    private int cont=0;

    @Override
    public int nMasUno() {
        n = series(n0) + n;
        return n;
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

    public int series (int ni){
        int nMas;

        switch (ni){
            case 2:
                nMas= 2;
                break;

            case 1:
                nMas = 2;
                break;

            case 3:
                nMas=3;
                break;

            default:
                nMas=0;
        }
        return nMas;
    }

    public int valorN (){
        cont++;
        if (cont <= 1 ) {
            return n0;
        }else {return nMasUno();}

    }

}
