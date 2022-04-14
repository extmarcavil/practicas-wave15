package ejercicioClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        Clase1 clase1 = new Clase1();
        clase1.establecerValorInicial(1);

        int contador = 1;

        while (contador < 9 ){
            System.out.println(clase1.valorN());
            contador++;
        }

        clase1.reiniciarSeri();

        System.out.println("--------------");

        contador = 1;

        while (contador < 9 ){
            System.out.println(clase1.valorN());
            contador++;
        }



    }
}
