package clasesAbstractas.main;

import clasesAbstractas.clases.SerieNumerica2;

public class Main {
    public static void main(String[] args) {
        SerieNumerica2 serieNumerica2=new SerieNumerica2(0);
        serieNumerica2.init(2);

        for (int i = 0; i < 10; i++) {
            System.out.println(serieNumerica2.next());
        }

        serieNumerica2.reset();
        for (int i = 0; i < 10; i++) {
            System.out.println(serieNumerica2.next());
        }

        serieNumerica2.init(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(serieNumerica2.next());
        }

    }
}
