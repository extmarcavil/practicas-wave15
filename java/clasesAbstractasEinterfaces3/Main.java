package clasesAbstractasEinterfaces3;


public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();

        perro.emitirSonido();

        perro.comeCarne();

        Gato gato = new Gato();

        gato.comeCarne();

        gato.emitirSonido();

        Vaca vaca = new Vaca();

        vaca.comeHierba();

        vaca.emitirSonido();

        Animal.comerAnimal(vaca);
    }
}
