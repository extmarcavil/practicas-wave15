package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro(Animal.Tipo.MASCOTA);
        Gato gato = new Gato(Animal.Tipo.MASCOTA);
        Vaca vaca = new Vaca(Animal.Tipo.ANIMALDEGRANJA);

        perro.emitirSonido();
        perro.comerCane();
        gato.emitirSonido();
        gato.comerCane();
        vaca.emitirSonido();
        vaca.comerHierba();
        vaca.comerAnimal();
        gato.comerAnimal();

    }
}
