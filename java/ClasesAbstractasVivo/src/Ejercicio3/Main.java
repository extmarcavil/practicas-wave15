package Ejercicio3;

public class Main {

    public static void main(String args[]){
        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        Gato gato = new Gato();
        gato.comerAnimal();
        gato.emitirSonido();

        Vaca vaca = new Vaca();
        vaca.comerAnimal();
        vaca.emitirSonido();
    }

}
