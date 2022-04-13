package animales;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
