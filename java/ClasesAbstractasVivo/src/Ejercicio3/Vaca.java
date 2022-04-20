package Ejercicio3;

public class Vaca extends Animal implements Herviboro{

    public Vaca(){
        super("muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca comió hierba");
    }

    public void comerAnimal(){
        comerHierba();
    }
}
