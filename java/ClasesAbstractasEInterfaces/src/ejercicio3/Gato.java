package ejercicio3;

public class Gato extends Animal implements ComerCarne {

    @Override
    void sonido() {
        System.out.println("Miau");
    }

    @Override
    void serComido() {
        System.out.println("Comiendo un gato...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        animal.serComido();
    }
}
