package clasesAbstractasEinterfaces3;

public abstract class Animal {

    Gato gato;
    Perro perro;
    Vaca vaca;

    abstract void comerAnimal();

    String emitirSonidos(){
        return "Holaa";
    }

    static void comerAnimal(Animal a){
        a.comerAnimal();
    }


}
