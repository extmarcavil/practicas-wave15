package Persona;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre + " // Edad: " + this.edad + " // DNI: " + this.dni + " // Peso: " + this.peso + " // Altura: " + this.altura;
    }

    public int calcularIMC(){
        float imc = (float) (this.peso / (Math.pow(this.altura, 2f)));
        if (imc < 20){
            return -1;
        } else if (imc <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad > 17;
    }
}
