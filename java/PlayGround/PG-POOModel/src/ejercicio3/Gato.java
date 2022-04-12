package ejercicio3;

public class Gato extends Animal implements Carnivoros{

    public Gato() {
        nombre = "Gato";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Gato dice : Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato dice : Soy un gato y adoro la carne!, Miau");
    }

    @Override
    public void comerAnimal(Animal animalASerComido) {
        System.out.println( "Gato dice : " + animalASerComido.nombre() + " ahumada seria una excelente cena");
    }
}
