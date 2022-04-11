public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("MUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }
}
