package abstractas;

public class Main {
    public static void main(String[] args) {
        SerieInteger s1 = new SerieInteger(1);
        SerieDouble s2 = new SerieDouble(5.5);

        s1.setInicio(1);
        s2.setInicio(1.1);

        for (int i = 0; i<5; i++){
            System.out.print("Serie 1: ");
            s1.siguiente();
        }

        System.out.println("\n==================\n");

        for (int i = 0; i < 5; i++) {
            System.out.print("Serie 2: ");
            s2.siguiente();
        }

        System.out.println("\n==================\n");

        s1.setInicio(8);
        s2.setInicio(8.8);

        for (int i = 0; i<5; i++){
            System.out.print("Serie 1: ");
            s1.siguiente();
        }

        System.out.println("\n==================\n");

        for (int i = 0; i < 5; i++) {
            System.out.print("Serie 2: ");
            s2.siguiente();
        }
    }
}
