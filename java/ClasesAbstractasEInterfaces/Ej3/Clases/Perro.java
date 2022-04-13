package ClasesAbstractasEInterfaces.Ej3.Clases;

import ClasesAbstractasEInterfaces.Ej3.Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("GUAU!!!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
