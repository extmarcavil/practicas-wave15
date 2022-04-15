public class SerieNumericaLong extends Prototipo<Long> {

    private Long valorInicial;
    private int tipoSerie;

    public SerieNumericaLong(Long valorInicial, int tipoSerie) {
        this.valorInicial = valorInicial;
        this.tipoSerie = tipoSerie;
    }

    @Override
    Long devolverValorSiguiente() {
        Long valorActual;
        switch (tipoSerie){
            case 1:
                valorInicial = valorInicial + 1L;
            case 2:
                valorInicial = valorInicial + 2L;
            case 3:
                valorInicial = valorInicial + 3L;
        }
        return valorInicial;
    }

    @Override
    void resetSerie() {
        establecerValorInicial(valorInicial);
    }

    @Override
    void establecerValorInicial(Long number) {
        this.valorInicial = number;
    }
}
