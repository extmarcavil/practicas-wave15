public class Vaca extends Animal implements Hervivoro{

    public void emitirSonido(){

        System.out.println("Muu Muu");
    }

    @Override
    public void comerHierba() {

        System.out.println("Comiendo hierba");
    }
}
