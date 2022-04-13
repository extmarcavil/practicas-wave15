package Persona;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularImc(){
        double imc = peso / (altura*altura);

        if (imc < 20)
            return -1;
        else
            if (imc >= 20 && imc <=25)
                return 0;
            else
                return 1;
    }

    public boolean esMayorDeEdad(){
        if (edad >= 18)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Persona:" + '\n' +
                "-------" + '\n' +
                "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "DNI: " + dni + '\n' +
                "Altura: " + altura + '\n' +
                "Peso: " + peso;
    }
}
