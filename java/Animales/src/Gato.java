public class Gato extends Animal implements ICarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    boolean esComestible() {
        return false;
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne.");
    }
}
