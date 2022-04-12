package principal;

public class SerieProgresiva extends Prototipo<Integer>{

    @Override
    public Integer getValorSig() {
        Integer sig= getValorActual()+getProgresion();
        setValorActual(sig);
        return sig;
    }

}
