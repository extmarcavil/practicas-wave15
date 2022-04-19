package EjercicioPracticoClasesAbstractasEInterfaces.Animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guaau");
    }

    @Override
    void comerAnimal() {
        this.comeCarne();
    }

    @Override
    public void comeCarne() {
        System.out.println("Perro come carne");
    }
}
