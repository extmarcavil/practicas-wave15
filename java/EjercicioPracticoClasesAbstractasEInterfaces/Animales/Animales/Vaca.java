package EjercicioPracticoClasesAbstractasEInterfaces.Animales.Animales;

public class Vaca extends Animal implements Herbivoro{
    @Override
    void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    void comerAnimal() {
        this.comeHierba();
    }

    @Override
    public void comeHierba() {
        System.out.println("Vaca come pasto");
    }
}
