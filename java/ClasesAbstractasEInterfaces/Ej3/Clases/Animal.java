package ClasesAbstractasEInterfaces.Ej3.Clases;

import ClasesAbstractasEInterfaces.Ej3.Interfaces.Sonido;

public class Animal implements Sonido {

    @Override
    public void emitirSonido() {
        System.out.println("Animal: Emitiendo sonido");
    }
}
