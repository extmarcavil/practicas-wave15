package animales;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
