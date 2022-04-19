package Main;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Klaus", 35, 2332323, 100, 1.72);
        Persona persona3 = new Persona("Klaus", 35, 2323232);
    }
}
