public class Main {
    public static void main(String[] args) {

        Integer numberInicial= 5;
        SerieNumericaInteger serieNumericaInteger = new SerieNumericaInteger(2);
        serieNumericaInteger.establecerValorInicial(numberInicial);
        System.out.println(serieNumericaInteger.devolverValorSiguiente());
        System.out.println(serieNumericaInteger.devolverValorSiguiente());
        serieNumericaInteger.resetSerie();




    }
}
