package ejercicioClasesAbstractas;

public class Main {
    public static void main(String[] args) {

        int contador = 1;
        Serie_2 serie_2 = new Serie_2();
        serie_2.establecerValorInicial(1);

        while (contador < 9 ){
            System.out.println(serie_2.nMasUno());
            contador++;
        }

        System.out.println("---------------------------------------");

        contador = 1;
        Serie_3 serie_3 = new Serie_3();
        serie_3.establecerValorInicial(15);

        while (contador < 9 ){
            System.out.println(serie_3.nMasUno());
            contador++;
        }
    }
}
