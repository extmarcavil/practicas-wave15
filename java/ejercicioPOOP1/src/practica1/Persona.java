package practica1;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        int resultado = 0;
        double imc = this.peso/Math.pow(altura,2);
        if (imc<20.0){
            resultado = -1;
        }
        else{
            if (imc > 25.0) {
                resultado = 1;
            }
        }
        return resultado;
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    public String toString(){
        return "Nombre: "+nombre+ "\nEdad: "+edad+"\nDNI: "+dni+"\nPeso: "+peso+" Kg\nAltura: "+altura+" Mts";
    }
}
