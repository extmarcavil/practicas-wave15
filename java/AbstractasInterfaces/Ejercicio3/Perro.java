package AbstractasInterfaces.Ejercicio3;

public class Perro extends Animal implements Carnivoros {


    public Perro() {
        super("guau");
    }

    @Override
    public void hablar() {
        super.hablar();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
