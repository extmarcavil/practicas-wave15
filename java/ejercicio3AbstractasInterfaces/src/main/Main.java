package main;

public class Main {

    public static void main(String[] args) {
        Perro perro1 = new Perro();
        perro1.hacerRuido();
        perro1.comerCarne();
        System.out.println("-----");
        Gato gato1 = new Gato();
        gato1.hacerRuido();
        gato1.comerCarne();
        System.out.println("-----");
        Vaca vaca1 = new Vaca();
        vaca1.hacerRuido();
        vaca1.comerHierba();
    }
}
