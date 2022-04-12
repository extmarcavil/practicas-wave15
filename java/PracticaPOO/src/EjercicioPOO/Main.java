package EjercicioPOO;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Pedro", 12345789, 21);

        Persona persona3 = new Persona("Juan", 123456789, 30, 43.5f, 1.60f);

        System.out.println(persona3.toString());

    }
}
