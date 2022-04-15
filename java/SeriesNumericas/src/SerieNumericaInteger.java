public class SerieNumericaInteger extends Prototipo<Integer>{



    private Integer valorInicial;
    private int tipoSerie;
     Integer valorReset = 0;

    public SerieNumericaInteger( int tipoSerie) {
        this.tipoSerie = tipoSerie;
    }

    @Override
    Integer devolverValorSiguiente() {
        int cont = 0;
        Integer valorFinal= 0;
        if(tipoSerie == 1){establecerValorInicial(valorInicial + 1); valorFinal = valorInicial;}
        if(tipoSerie == 2){establecerValorInicial(valorInicial + 2); valorFinal = valorInicial;}
        if(tipoSerie == 3){establecerValorInicial(valorInicial + 3); valorFinal = valorInicial;}
        valorReset = valorReset + 1;
        return valorFinal;
    }

    @Override
    void resetSerie() {
        Integer valorFinal= 0;
        Integer valorCont = 0;
        while ( valorCont< this.valorReset){
        if(tipoSerie == 1){ valorFinal = valorInicial - 1;}
        if(tipoSerie == 2){ valorFinal = valorInicial - 2;}
        if(tipoSerie == 3){ valorFinal = valorInicial - 3;}
        }

        System.out.println(valorFinal);
    }

    @Override
    void establecerValorInicial(Integer number) {
        this.valorInicial = number;
        //System.out.println(" ahora el inicial es : " + number);
    }





    }



