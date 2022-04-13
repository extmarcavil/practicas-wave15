package ejercicioAnimales;

public class Vaca extends Animal implements Herviboro {
    @Override
    void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca que come hierba.");
    }
}
