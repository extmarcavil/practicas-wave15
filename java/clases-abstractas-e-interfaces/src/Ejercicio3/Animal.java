package Ejercicio3;

public abstract class Animal {
    public abstract void emitirSonido();
    public abstract void comer();
    public static void comerAnima(Animal animal) {
        animal.comer();
    }
}
