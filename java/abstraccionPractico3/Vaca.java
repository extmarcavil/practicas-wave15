package abstraccionPractico3;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu muuu");
    }

    @Override
    public void comer() {
        Herbivoro.comerHierba();
    }
}
