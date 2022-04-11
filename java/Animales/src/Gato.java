public class Gato  extends Animal{

    public Gato(int tipoGusto) {
        super(tipoGusto);
    }

    @Override
    public void EmiteSonido() {
        System.out.println("Miauuuu!!");
    }
}
