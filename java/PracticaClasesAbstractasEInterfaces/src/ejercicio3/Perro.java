package ejercicio3;

public class Perro extends Animal implements ComerCarne{
    public Perro(Tipo tipo) {
        super(tipo);
    }

    @Override
    void emitirSonido() {
        System.out.println("Guau Guau Guau Guau ");
    }

    @Override
    public void comerCane() {
        System.out.println("Perro comiendo carne ");
    }
}
