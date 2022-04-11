public class Perro extends  Animal{

    public Perro(int tipoGusto) {
        super(tipoGusto);
    }

    @Override
    public void EmiteSonido() {
        System.out.println("Guauuuu!!");
    }
}
