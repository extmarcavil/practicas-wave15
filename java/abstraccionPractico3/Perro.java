package abstraccionPractico3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("xd, digo Guau Guau");
    }

    @Override
    public void comer() {
        Carnivoro.comerCarne();
    }
}
