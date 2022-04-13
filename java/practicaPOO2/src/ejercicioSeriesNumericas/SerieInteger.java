package ejercicioSeriesNumericas;

public class SerieInteger extends Prototipo<Integer> {

    public SerieInteger() {
    }

    public SerieInteger(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public void crearSerie() {

        if (getValorInicial().intValue() != 0) {
            if (getValorSiguiente().intValue() == 0)
                setValorSiguiente(getValorInicial().intValue() + getIncremento().intValue());
            else setValorSiguiente(getValorSiguiente().intValue() + getIncremento().intValue());
        } else {
            setValorSiguiente(getValorSiguiente().intValue() + getIncremento().intValue());
        }

        System.out.println("Siguiente número en la serie: " + getValorSiguiente().intValue());
    }

    @Override
    public void reiniciarSerie() {
        setValorSiguiente(getValorInicial());
    }

    @Override
    public void establecerValorInicial(Integer nro) {
        super.setValorInicial(nro.intValue());
    }
}

