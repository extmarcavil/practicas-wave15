public class Vaca  extends Animal{

    public Vaca(int tipoGusto) {
        super(tipoGusto);
    }

    @Override
    public void EmiteSonido() {
        System.out.println("Muuuu!!");
    }
}
