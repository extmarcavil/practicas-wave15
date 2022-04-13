package abstraccionPractico3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau Miau");
    }

    @Override
    public void comer() {
        Carnivoro.comerCarne();
    }
}
