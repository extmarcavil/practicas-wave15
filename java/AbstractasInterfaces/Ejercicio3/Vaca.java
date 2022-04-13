package AbstractasInterfaces.Ejercicio3;

public class Vaca extends Animal implements Herviboro {


    public Vaca() {
        super("muuu");
    }

    @Override
    public void hablar() {
        super.hablar();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
