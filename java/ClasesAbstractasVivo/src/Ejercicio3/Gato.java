package Ejercicio3;

public class Gato extends Animal implements Carnivoro{

    public Gato(){
        super("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato comió carne");
    }

    public void comerAnimal(){
        comerCarne();
    }
}
