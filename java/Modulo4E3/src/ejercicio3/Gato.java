package ejercicio3;

public class Gato extends Animal implements ComerCarne{

    public Gato(String sonido, Boolean comeAnimal) {
        super(sonido, comeAnimal);
    }

    @Override
    public String emitirSonido() {
        return "Miau";
    }


    @Override
    public boolean comerCarne() {
    return true;
    }
}
