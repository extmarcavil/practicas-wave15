package ejercicio;

public class SerieDouble extends SeriePrototipo<Double>{

        public SerieDouble(Double valorInicial, Double factorDeIncremento) {
            super(valorInicial, factorDeIncremento);
        }

        @Override
        public Double obtenerProximoNumero() {
            valorActual += factorDeIncremento;
            return valorActual;
        }


    }
