package Clases;

public class Main {
    public static void main(String[] args) {

        Serie serie = new Serie(2);

        System.out.println("-----------------------");

        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());

        System.out.println("-----------------------");
        serie.inicializar(1);

        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());

        System.out.println("-----------------------");
        serie.inicializar(3);

        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
        System.out.println(serie.siguiente_valor());
    }
}
