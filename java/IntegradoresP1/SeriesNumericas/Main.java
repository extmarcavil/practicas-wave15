package IntegradoresP1.SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2(0);
        Serie3 serie3 = new Serie3(0.0);

        System.out.println("Serie de a 2");
        System.out.println(serie2.getNroInicial());
        System.out.println(serie2.getSiguienteValor());
        System.out.println(serie2.getSiguienteValor());
        System.out.println("Iniciar en 5");
        serie2.setNroInicial(5);
        System.out.println(serie2.getNroInicial());
        System.out.println(serie2.getSiguienteValor());
        System.out.println(serie2.getSiguienteValor());


        System.out.println();
        System.out.println("Serie de a 3");
        System.out.println(serie3.getNroInicial());
        System.out.println(serie3.getSiguienteValor());
        System.out.println(serie3.getSiguienteValor());
        System.out.println("Iniciar en 5.1");
        serie3.setNroInicial(5.1);
        System.out.println(serie3.getNroInicial());
        System.out.println(serie3.getSiguienteValor());
        System.out.println(serie3.getSiguienteValor());
    }
}
