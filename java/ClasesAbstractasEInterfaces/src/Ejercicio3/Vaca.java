package Ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuu");
    }

    @Override
    public void comerHierba() {
        emitirSonido();
        System.out.println("Oh god, why?");
    }
}
