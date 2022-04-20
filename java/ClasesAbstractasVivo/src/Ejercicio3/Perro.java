package Ejercicio3;

public class Perro extends Animal implements Carnivoro{

    public Perro(){
        super("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro comió carne");
    }

    public void comerAnimal(){
        comerCarne();
    }
}
