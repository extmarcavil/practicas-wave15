package Ejercicio3;

public class Gato extends Animal implements Comestible{

    public Gato() {
        super("MIAU");
    }


    @Override
    public void comerCarne() {
        System.out.println("Me gusta la carne");
    }

    @Override
    public void comerPlantas() {
        System.out.println("No me gusta las plantas");
    }
}
