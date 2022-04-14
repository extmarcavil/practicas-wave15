package ejercicio3;

public class Vaca extends Animal implements ComerHierba{
    public Vaca(Tipo tipo) {
        super(tipo);
    }

    @Override
    void emitirSonido() {
        System.out.println("MUUUUUUUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
}
