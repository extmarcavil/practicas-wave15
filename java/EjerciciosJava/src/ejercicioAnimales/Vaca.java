package ejercicioAnimales;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comer hierva del campo");
    }
}
