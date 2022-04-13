package animales;

public class Vaca extends Animal implements Herviboro{
    @Override
    protected void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    protected void comer() {
        comerHierva();
    }

    @Override
    public void comerHierva() {
        System.out.println("Come hierva.");
    }
}
