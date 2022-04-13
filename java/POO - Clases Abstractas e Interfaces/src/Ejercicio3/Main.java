package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Gato g = new Gato();
        Perro p = new Perro();
        Vaca v = new Vaca();

        System.out.println(p.comerCarne());
        System.out.println(g.comerCarne());
        System.out.println(v.comerHierba());

    }
}
