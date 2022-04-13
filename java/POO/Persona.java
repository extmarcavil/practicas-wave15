package POO;

public class Persona {

    public String nombre;
    public int edad;
    public String dni;
    public double peso;
    public double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){

        double imc = peso / (altura * altura);

        if(imc < 20){
            return -1;
        }
        else if(imc >= 20 && imc <= 25){
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
    }
}
