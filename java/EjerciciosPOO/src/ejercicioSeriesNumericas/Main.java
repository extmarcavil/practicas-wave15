package ejercicioSeriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieEnteros serie2 = new SerieEnteros(2);
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        System.out.println();
        serie2.iniciarSerie(1);
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());
        System.out.println(serie2.siguienteValor());

        serie2.reiniciarSerie();
        System.out.println("\n" + serie2.siguienteValor() + "\n");

        SerieEnteros serie3 = new SerieEnteros(3);
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());
        System.out.println(serie3.siguienteValor());

        System.out.println();
        SerieDouble serieDouble = new SerieDouble(2.5);
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
    }
}
