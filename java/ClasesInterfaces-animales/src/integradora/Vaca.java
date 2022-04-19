package integradora;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
