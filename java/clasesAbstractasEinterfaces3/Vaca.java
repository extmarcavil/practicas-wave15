package clasesAbstractasEinterfaces3;

public class Vaca extends Animal implements ComeHierba{

    public String emitirSonido(){
        return "muuu";

    }
    @Override
    void comerAnimal() {
        this.comeHierba();
    }

    @Override
    public String comeHierba() {
        return null;
    }
}
