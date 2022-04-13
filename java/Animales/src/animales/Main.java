package animales;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
    }
}
