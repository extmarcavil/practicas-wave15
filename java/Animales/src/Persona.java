public class Persona {
    public void comerAnimal (Animal animal){
        if (animal.esComestible()){
            System.out.println("Me estoy comiendo un/a " + animal.getClass().getSimpleName() + ".");
        } else {
            System.out.println("El animal " + animal.getClass().getSimpleName() + " no se come.");
        }

    }

}
