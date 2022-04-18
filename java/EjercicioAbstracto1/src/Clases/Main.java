package Clases;

public class Main {
    public static void main(String[] args) {
        Serie serie = new Serie(3,2);
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println("---------");

        serie.reiniciarValor();
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());

        serie.reiniciarValor();
        serie.setValor(9);
        System.out.println("---------");
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
        System.out.println(serie.siguienteValor());
    }
}
