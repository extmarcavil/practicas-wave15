package ejercicioAnimales;

/*Se solicita la creación de una clase abstracta denominada Animal, de la cual deriven 3 animales: Perro, Gato y Vaca.
Los 3 animales son capaces de “emitir sonidos”, para ello será necesario implementar un método que permita mostrar
por pantalla el sonido que emite cada animal. Por ejemplo, en el caso del perro “guau”, el gato “miau” y la vaca “muuu”.
A partir de esto, teniendo en cuenta los gustos alimenticios de cada animal (gato y perro son considerados carnívoros
y la vaca un hervíboro), incluir las interfaces necesarias para contemplar los métodos comerCarne o comerHierba.
Una vez realizado lo mencionado, llevar a cabo en el Main la creación de diferentes animales y la invocación de sus
respectivas implementaciones de métodos.

Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de cualquier tipo
de animal como parámetro, invoque al método para comer según corresponda a dicho animal.*/


public class EjercicioAnimales {
    public static void main(String[] args) {
        Perro perro = new Perro();
        System.out.println("Perro:");
        perro.comerCarne();
        perro.emitirSonido();

        System.out.println();

        Gato gato = new Gato();
        System.out.println("Gato:");
        gato.comerCarne();
        gato.emitirSonido();

        System.out.println();

        Vaca vaca = new Vaca();
        System.out.println("Vaca:");
        vaca.comerHierba();
        vaca.emitirSonido();

        System.out.println();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if(animal instanceof Perro) {
            System.out.println("Perro: no comer");
        }
        else if (animal instanceof Gato) {
            System.out.println("Gato: no comer");
        }
        else {
            System.out.println("Vaca: comer");
        }
    }
}
