public class Gato extends Animal implements Carnivoro{

    public void emitirSonido(){

        System.out.println("Miau Miau");
    }

    @Override
    public void comerCarne() {

        System.out.println("Comiendo carne");
    }
}
