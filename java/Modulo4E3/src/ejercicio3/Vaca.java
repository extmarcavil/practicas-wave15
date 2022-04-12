package ejercicio3;

public class Vaca extends Animal implements ComerHierba{



    public Vaca(String sonido, Boolean comeAnimal) {
        super(sonido, comeAnimal);
    }

    @Override
    public String emitirSonido() {
        return "Muuu";
    }

    @Override
    public boolean comerHierba() {
        return true;
    }
}
