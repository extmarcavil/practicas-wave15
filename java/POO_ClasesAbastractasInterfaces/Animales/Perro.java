package POO_ClasesAbastractasInterfaces.Animales;

public class Perro extends Animal implements GustosAlimenticios{
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne....");
    }

    @Override
    public void comerHierba() {
        System.out.println("No me gustan las hierbas...");

    }
}
