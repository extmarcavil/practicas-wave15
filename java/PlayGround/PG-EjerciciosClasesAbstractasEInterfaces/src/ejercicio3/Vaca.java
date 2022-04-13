package ejercicio3;

public class Vaca extends Animal implements Herviboro{

    public Vaca() {
        nombre = "Vaca";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Vaca dice : Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca dice : Soy una vaca y me gusta el pastito");
    }
}
