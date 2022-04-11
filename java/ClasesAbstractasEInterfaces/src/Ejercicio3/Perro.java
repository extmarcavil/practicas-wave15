package Ejercicio3;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Waw wawww");
    }

    @Override
    public void comerCarne() {
        emitirSonido();
        System.out.println("Que rico gato");
    }
}
