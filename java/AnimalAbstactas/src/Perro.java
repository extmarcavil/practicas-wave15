public class Perro extends Animal implements Carnivoro{

    public void emitirSonido(){

        System.out.println("Guau Guau");
    }

    @Override
    public void comerCarne() {

        System.out.println("Comiendo carne");
    }
}
