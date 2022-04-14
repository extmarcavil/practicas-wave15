package ejercicio3;

public class Gato extends Animal implements ComerCarne{
    public Gato(Tipo tipo) {
        super(tipo);
    }

    @Override
    void emitirSonido() {
        System.out.println("Miau Miau Miauuuuuuu");
    }

    @Override
    public void comerCane() {
        System.out.println("Gato comiendo carne ");
    }
}
