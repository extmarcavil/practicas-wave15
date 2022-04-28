import model.Serie2;
import model.Serie2Double;
import model.Serie3;

public class App {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        for(int i = 1; i <= 4; i++) {
            System.out.println(serie2.nextValue());
        }

        System.out.println("-------");

        serie2.initSerie(1);
        for(int i = 1; i <= 4; i++) {
            System.out.println(serie2.nextValue());
        }

        System.out.println("-------");

        Serie3 serie3 = new Serie3();
        for(int i = 1; i <= 4; i++) {
            System.out.println(serie3.nextValue());
        }

        System.out.println("-------");

        Serie2Double serie2Double = new Serie2Double();
        for(int i = 1; i <= 4; i++) {
            System.out.println(serie2Double.nextValue());
        }
    }
}
