package Ejercicio3;

public class Gato extends Animales implements Carnivoro {

    public Gato() {}
    @Override
    void emitir_sonidos() {
        System.out.println("Miauu");
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne.";
    }
}
