public class Vaca extends Animal implements IHerviboro{
    @Override
    void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    boolean esComestible() {
        return true;
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba.");
    }
}
