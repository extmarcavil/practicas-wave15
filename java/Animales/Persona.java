package Animales;

public class Persona {
    public void comerAnimal(Animal animal) {
        if (animal.esComestible()) {
            System.out.println("Me estoy comiendo un/a rico/a " + animal.getClass().getSimpleName());
        } else {
            System.out.println("TAS LOCO, COMO TE VAS A COMER UN/A " + animal.getClass().getSimpleName());
        }
    }
}