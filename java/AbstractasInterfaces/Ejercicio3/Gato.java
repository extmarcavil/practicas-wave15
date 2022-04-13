package AbstractasInterfaces.Ejercicio3;

public class Gato extends Animal implements Carnivoros {


    public Gato() {
        super("miau");
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
