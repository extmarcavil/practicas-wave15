package ejercicio3;

public class Perro extends Animal implements ComerCarne{

    public Perro(String sonido, Boolean comeAnimal) {
        super(sonido, comeAnimal);
    }

    @Override
    public String emitirSonido() {
        return "Guau";
    }


    @Override
    public boolean comerCarne() {
        return true;
    }
}
