package clasesAbstractasEinterfaces3;

public class Gato extends Animal implements ComeCarne {
    public String emitirSonido(){
        return "miau";

    }

    @Override
    public String comeCarne() {
        return "soy carnivoro";
    }

    @Override
    void comerAnimal() {
        this.comeCarne();
    }


}
