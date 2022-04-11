package ejercicio3;

public class Gato extends Animal implements GustoAlimenticio {
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("mmm... rico!");
    }

    @Override
    public void comerHierba() {
        System.out.println("no quiero eso :(");
    }

    @Override
    public void comer() {

    }
}