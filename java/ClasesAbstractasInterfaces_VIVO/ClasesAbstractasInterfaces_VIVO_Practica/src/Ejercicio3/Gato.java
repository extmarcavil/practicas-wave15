package Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("MIAU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }

    @Override
    public void comerAnimal(Animal comida) {
        System.out.println("Comiendo carne de otro animal");
    }
}
