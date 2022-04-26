public class Gato extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Miaau");
    }

    @Override
    void comerAnimal() {
        this.comeCarne();
    }

    @Override
    public void comeCarne() {
        System.out.println("Gato come carne");
    }
}
