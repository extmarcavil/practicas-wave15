public class App {
    public static void main(String[] args) {
        Animal animal = new Gato();
        animal.emitirSonido();
        ((Gato)animal).comerCarne();
        comerAnimal(animal);

        animal = new Perro();
        animal.emitirSonido();
        ((Perro) animal).comerCarne();
        comerAnimal(animal);

        animal = new Vaca();
        animal.emitirSonido();
        ((Vaca) animal).comerHierba();

        comerAnimal(animal);
    }

    private static void comerAnimal(Animal animal){
        if(animal instanceof Gato || animal instanceof Perro){
            ((Carnivoro) animal).comerCarne();
        } else {
            ((Vaca)animal).comerHierba();
        }
    }
}
