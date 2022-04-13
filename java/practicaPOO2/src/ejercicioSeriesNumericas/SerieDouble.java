package ejercicioSeriesNumericas;

public class SerieDouble extends Prototipo<Double> {

    public SerieDouble() {
    }

    public SerieDouble(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public void crearSerie() {

        if (getValorInicial().doubleValue() != 0) {
            if (getValorSiguiente().doubleValue() == 0)
                setValorSiguiente(getValorInicial().doubleValue() + getIncremento().doubleValue());
            else setValorSiguiente(getValorSiguiente().doubleValue() + getIncremento().doubleValue());
        } else {
            setValorSiguiente(getValorSiguiente().doubleValue() + getIncremento().doubleValue());
        }

        System.out.println("Siguiente número en la serie: " + getValorSiguiente().doubleValue());
    }

    @Override
    public void reiniciarSerie() {
        setValorSiguiente(getValorInicial().doubleValue());
    }

    @Override
    public void establecerValorInicial(Double nro) {
        super.setValorInicial(nro.doubleValue());
    }
}

