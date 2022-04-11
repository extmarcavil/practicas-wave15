public class Index {
    public static void main(String[] args) {
        var perro = new Perro(1);
        perro.EmiteSonido();
        perro.comerAnimal();

        var gato = new Gato(1);
        gato.EmiteSonido();
        gato.comerAnimal();

        var vaca = new Vaca(2);
        vaca.EmiteSonido();
        vaca.comerAnimal();
    }
}
