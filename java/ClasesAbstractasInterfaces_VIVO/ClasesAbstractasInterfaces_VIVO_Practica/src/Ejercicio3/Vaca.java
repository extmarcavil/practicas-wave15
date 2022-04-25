package Ejercicio3;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("MUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierbas");

    }
}
