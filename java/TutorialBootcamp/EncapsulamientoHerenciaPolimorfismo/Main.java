package TutorialBootcamp.EncapsulamientoHerenciaPolimorfismo;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro("Perro", "Shicle");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Animal gato = new  Gato ("Gato", "Luna");
        gato.mostrarEspecie();
        gato.hacerSonido();
    }
}
