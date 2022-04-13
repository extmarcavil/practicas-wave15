package series;

public class Main {
    public static void main(String[] args) {
        SerieInteger serieInteger = new SerieInteger(5);
        serieInteger.establecerInicio(3);
        System.out.println(serieInteger.siguienteValor());
        System.out.println(serieInteger.siguienteValor());
        System.out.println(serieInteger.siguienteValor());
        serieInteger.reiniciarSerie();
        System.out.println(serieInteger.siguienteValor());
        System.out.println(serieInteger.siguienteValor());
        System.out.println(serieInteger.siguienteValor());

        SerieDouble serieDouble = new SerieDouble(2.5);
        serieDouble.establecerInicio(2.0);
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
    }
}
