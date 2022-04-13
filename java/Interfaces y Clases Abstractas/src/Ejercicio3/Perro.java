package Ejercicio3;

public class Perro extends Animal implements Comestible{

    public Perro() {
        super("GUAU");
    }


    @Override
    public void comerCarne() {
        System.out.println("Me gusta");
    }

    @Override
    public void comerPlantas() {
        System.out.println("No me gusta");
    }
}
