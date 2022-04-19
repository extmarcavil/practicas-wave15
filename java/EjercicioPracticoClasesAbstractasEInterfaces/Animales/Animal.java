package EjercicioPracticoClasesAbstractasEInterfaces.Animales;

public abstract class Animal {
    abstract void emitirSonido();
    abstract void comerAnimal();

    static void comerAnimal(Animal a){
        a.comerAnimal();
    }

}
