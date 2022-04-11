package Ejercicio3;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuuu");
    }

    @Override
    public void comerCarne() {
        emitirSonido();
        System.out.println("Que rico raton");
    }
}
