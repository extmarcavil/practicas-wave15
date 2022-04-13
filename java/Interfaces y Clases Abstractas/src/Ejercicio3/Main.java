package Ejercicio3;

public class Main {
    public static void main(String[] args) {

        System.out.println("Perro");
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        perro.comerPlantas();

        System.out.println("\nVACA");
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerCarne();
        vaca.comerPlantas();
        vaca.comerAnimal(vaca);

        System.out.println("\nGATO");
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        gato.comerPlantas();
    }
}
