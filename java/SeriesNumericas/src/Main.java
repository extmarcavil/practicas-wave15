
public class Main {
    public static void main(String[] args) {

        SerieEntero s2 = new SerieEntero(2);
        System.out.println("Serie Entero valor inicial 2");
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());

        SerieEntero s3 = new SerieEntero(3);
        System.out.println("Serie Entero valor inicial 3");
        System.out.println(s3.siguiente());
        System.out.println(s3.siguiente());
        System.out.println(s3.siguiente());
        System.out.println(s3.siguiente());

        s2.iniciarSerie(1);
        System.out.println("Serie Entero valor inicial 1, con serie reiniciada");
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());
        System.out.println(s2.siguiente());

        SerieDouble s3_5 = new SerieDouble(3.5);
        System.out.println("Serie Entero valor inicial 3.5");
        System.out.println(s3_5.siguiente());
        System.out.println(s3_5.siguiente());
        System.out.println(s3_5.siguiente());
        System.out.println(s3_5.siguiente());



    }


}
