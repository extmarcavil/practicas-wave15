package AbstractasInterfaces.Ejercicio3;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.hablar();
        gato.hablar();
        vaca.hablar();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

    }
}
