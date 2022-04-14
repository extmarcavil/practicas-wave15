package Ejercicio3;

public class Perro extends Animales implements Carnivoro{

    public Perro() {}

    @Override
    void emitir_sonidos() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne.";
    }
}
