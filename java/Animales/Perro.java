package Animales;

public class Perro extends Animal implements Carnivoro {
    private String nombre;

    @Override
    void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }

    @Override
    boolean esComestible() {
        return false;
    }
}
