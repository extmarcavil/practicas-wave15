public class SerieEntero extends Prototipo<Integer>{
    public SerieEntero(Integer inicial) {
        super(inicial);
        this.actual = 0;
    }

    @Override
    public void reiniciarSerie() {
        actual = 0;
    }

    @Override
    public Integer siguiente() {
        if (inicial == 1 && actual == 0){
            actual = inicial +2;
        }else {
            actual = actual + inicial;
        }
        return actual;
    }


}
