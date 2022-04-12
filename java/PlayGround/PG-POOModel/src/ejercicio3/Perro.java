package ejercicio3;

public class Perro extends Animal implements Carnivoros{
    public Perro() {
        nombre = "Perro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Perro dice : Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro dice : Soy un perro y adoro la carne! Guau");
    }

    @Override
    public void comerAnimal(Animal animalASerComido) {
        System.out.println("Perro dice : Si tan solo me dieran una patita de " + animalASerComido.nombre() + " seria muy feliz");
    }
}
