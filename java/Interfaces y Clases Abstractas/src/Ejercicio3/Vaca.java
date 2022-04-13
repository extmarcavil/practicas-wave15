package Ejercicio3;

public class Vaca extends Animal implements Comestible{

    public Vaca() {
        super("MUUU");
    }


    @Override
    public void comerCarne() {
        System.out.println("No me gusta");
    }

    @Override
    public void comerPlantas() {
        System.out.println("Me gusta");
    }

    @Override
    public void comerAnimal(Animal animal) {
        super.comerAnimal(animal);
    }
}
