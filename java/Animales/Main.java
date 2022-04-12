package Animales;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        Persona persona = new Persona();

        persona.comerAnimal(perro);
        persona.comerAnimal(gato);
        persona.comerAnimal(vaca);
    }
}
