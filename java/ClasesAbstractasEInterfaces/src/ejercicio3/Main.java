package ejercicio3;

public class Main {

    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.sonido();
        vaca.comerHierba("pasto");
        perro.sonido();
        perro.comerAnimal(vaca);
        gato.sonido();
        gato.comerAnimal(vaca);
    }
}
