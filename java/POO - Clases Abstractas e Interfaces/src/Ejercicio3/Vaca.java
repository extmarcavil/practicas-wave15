package Ejercicio3;

public class Vaca extends Animales implements Herviboro{

    public Vaca() {}

    @Override
    void emitir_sonidos() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba() {
        return "Que rica la hierba.";
    }
}
