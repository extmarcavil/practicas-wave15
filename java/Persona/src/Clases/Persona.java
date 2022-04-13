package Clases;


public class Persona {

    String nombre;
    int edad;
    String dni;
    float peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }


    private String calcularMC(){
        double mc = peso / (altura * altura);
        if(mc<20){
            return "bajo peso";
        }
        else if(mc>=20 && mc<=25){
            return "peso saludable";
        }
        else{
            return "sobrepeso";
        }
    }

    private String esMayorDeEdad(){
        if(edad>=18){
            return "mayor de edad";
        }
        else{
            return "menor de edad";
        }
    }

    public String stringInfo(){
        String toString = "Información personal: " + nombre + ", " + esMayorDeEdad() + " (" + edad + " años), " + dni + ", " + calcularMC() + ".";
        return toString;
    }

}
