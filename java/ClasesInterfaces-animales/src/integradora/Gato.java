package integradora;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerAnimal() {
        System.out.println("El gato come sentado");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
