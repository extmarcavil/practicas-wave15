package ejercicio2;

public class Informe implements Imprimible{

    String texto;
    String nombreautor;
    String nombreRevisor;


    @Override
    public void imprimir() {
        System.out.println("Hola mundo");
        System.out.println("Autor: Silvia");
        System.out.println("Nombre del revisor: Meli");

    }
}
