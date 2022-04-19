package integradora;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerAnimal() {
        System.out.println("El perro come de pie");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

}
