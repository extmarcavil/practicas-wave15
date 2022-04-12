package clasesAbstractasEinterfaces3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Perro extends Animal implements ComeCarne{

    public String emitirSonido(){
        return "guauu";
    }
    List lista1 = new ArrayList();
    @Override
    public String comeCarne() {
        return "soy carnivoro";
    }
    @Override
    void comerAnimal() {
        this.comeCarne();
    }
}
