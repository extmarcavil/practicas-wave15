package SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Enteros-------------");
        Int serieEnteros = new Int(2);
        System.out.println(serieEnteros.siguienteValor());
        System.out.println(serieEnteros.siguienteValor());
        System.out.println(serieEnteros.siguienteValor());
        System.out.println(serieEnteros.siguienteValor());
        System.out.println(serieEnteros.siguienteValor());
        System.out.println(serieEnteros.siguienteValor());
        System.out.println("-------------------------------");

        Flotante serieFlotantes = new Flotante(2.55f);
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println("---reinicio--");
        serieFlotantes.reiniciarSerie();
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println(serieFlotantes.siguienteValor());
        System.out.println("-------------------------------");

        Doubles serieDouble = new Doubles(2.55);
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println(serieDouble.siguienteValor());
        System.out.println("-------------------------------");
    }
}
