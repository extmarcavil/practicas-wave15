package animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    protected void emitirSonido() {
        System.out.println("Guau");
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
