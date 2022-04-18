package ejercicio3;

public class Perro extends Animal implements ComerCarne {

    @Override
    void sonido() {
        System.out.println("Guau");
    }

    @Override
    void serComido() {
        System.out.println("Comiendo un perro...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        animal.serComido();
    }
}
