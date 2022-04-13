package ClasesAbstractasEInterfaces.Ej3;

import ClasesAbstractasEInterfaces.Ej3.Clases.Animal;
import ClasesAbstractasEInterfaces.Ej3.Clases.Gato;
import ClasesAbstractasEInterfaces.Ej3.Clases.Perro;
import ClasesAbstractasEInterfaces.Ej3.Clases.Vaca;

public class Main {
    public static void main(String[] args) {

        Animal vaca = new Vaca();
        vaca.emitirSonido();
        ((Vaca) vaca).comerHierba();

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
    }
}
