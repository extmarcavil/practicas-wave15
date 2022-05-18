public class Perro extends Animal implements ICarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    boolean esComestible() {
        return false;
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne.");
    }
}
