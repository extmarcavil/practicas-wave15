package EjercicioPracticoClasesAbstractasEInterfaces.Animales.Animales;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();

        System.out.println();

        Animal.comerAnimal(vaca);
        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);

        System.out.println();



    }

}
