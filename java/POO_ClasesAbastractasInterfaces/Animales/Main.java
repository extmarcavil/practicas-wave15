package POO_ClasesAbastractasInterfaces.Animales;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        System.out.println("Perro");
        perro.emitirSonido();
        perro.comerCarne();
        perro.comerHierba();
        System.out.println("--------------------------------");
        System.out.println("Gato");
        gato.emitirSonido();
        gato.comer();
        System.out.println("--------------------------------");
        System.out.println("Vaca");
        vaca.emitirSonido();
        vaca.comerCarne();
        vaca.comerHierba();
        System.out.println("--------------------------------");

    }
}
