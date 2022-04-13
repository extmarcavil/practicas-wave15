package ejercicioAnimales;

public class Gato extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato que come carne.");
    }
}
