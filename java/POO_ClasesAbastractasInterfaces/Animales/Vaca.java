package POO_ClasesAbastractasInterfaces.Animales;

public class Vaca extends Animal implements GustosAlimenticios{
    @Override
    public void emitirSonido() {
        System.out.println("Muu!");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerCarne() {
        System.out.println("No me gusta la Carne...");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo Hiervas...");

    }
}
