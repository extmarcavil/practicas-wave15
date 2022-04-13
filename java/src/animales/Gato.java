package animales;

public class Gato extends Animal implements Carnivoro{
    @Override
    protected void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    protected void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne.");
    }
}
