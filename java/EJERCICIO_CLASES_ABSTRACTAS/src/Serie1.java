public class Serie1 <T extends Number> extends Prototipo  {


    public Serie1(Number valorInicial, Number numSerie, Number cantidad) {
        super(valorInicial, numSerie, cantidad);
    }

    @Override
    public void  devolverSiguiente(Number valorInicial, Number numSerie, Number cantidad) {
        double result = valorInicial.doubleValue();
        System.out.println(valorInicial.doubleValue());
        for(int i = 0; i<cantidad.intValue(); i++) {
            System.out.println( result = result + numSerie.doubleValue()  );
        }
    }

    @Override
    public void reiniciar() {
        valorInicial = 0;
        numSerie = 0;
        cantidad = 0;


    }


}



/**
 * Si se crea una serie de 2 cada vez que se llame el método valor siguiente devolverá:
 * Primera vez 2
 * Segunda vez 4
 * Tercera vez 6
 * Cuarta vez 8
 *                                  Así sucesivamente cada vez que se llama al método.
 * Si por ejemplo se emplea el método para establecer un valor inicial 1, cada vez que se llame al método el valor siguiente devolverá:
 * Primera vez 3
 * Segunda vez 5
 * Tercera vez 7
 * Cuarta vez 9
 *                                 Así sucesivamente cada vez que se llama al método.
 * De igual forma si es una serie de 3, cada vez que se llame al método el valor siguiente devolverá:
 * Primera vez 3
 * Segunda vez 6
 * Tercera vez 9
 * Cuarta vez 12
 *                                 Así sucesivamente cada vez que se llama al método.
 *
 * */