package PersonaSaludable;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

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

    public int cacularIMC() {
        double IMC = peso / (Math.pow(altura, 2));
        if (IMC < 20 ){
            return -1;
        } else if (IMC >= 20 && IMC <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + dni + "\nPeso: " + peso + "\nAltura: " + altura +
                "\n";
    }
}
