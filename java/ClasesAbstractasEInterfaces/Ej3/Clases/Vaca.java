package ClasesAbstractasEInterfaces.Ej3.Clases;

import ClasesAbstractasEInterfaces.Ej3.Interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonido() {
        System.out.println("MUUU!!!");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
