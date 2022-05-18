public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro();
        Gato gato1 = new Gato();
        Vaca vaca1 = new Vaca();

        perro1.emitirSonido();
        gato1.emitirSonido();
        vaca1.emitirSonido();

        Persona persona1 = new Persona();

        persona1.comerAnimal(perro1);
        persona1.comerAnimal(gato1);
        persona1.comerAnimal(vaca1);
    }
}
