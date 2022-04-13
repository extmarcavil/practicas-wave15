package clases;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona1 = new Persona("Jose", 23);
        Persona persona2 = new Persona("Jose","40323213",18, 70f,1.72f);


        System.out.println(persona2.toString());

    }
}
