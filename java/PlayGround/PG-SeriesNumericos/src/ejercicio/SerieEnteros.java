package ejercicio;

public class SerieEnteros extends SeriePrototipo<Integer>{


    public SerieEnteros(Integer valorInicial, Integer factorDeIncremento) {
        super(valorInicial, factorDeIncremento);
    }

    @Override
    public Integer obtenerProximoNumero() {
        valorActual += factorDeIncremento;
        return valorActual;
    }


}
