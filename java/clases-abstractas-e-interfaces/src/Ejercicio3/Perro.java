package Ejercicio3;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo restos de pollo.");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
