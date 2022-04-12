package Animales;

public class Vaca extends Animal implements Herviboro {
    @Override
    void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comeHierba() {
        System.out.println("Come pasto");
    }

    @Override
    boolean esComestible() {
        return true;
    }
}
