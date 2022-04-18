package Modelo;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, float peso, float altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = this.peso/Math.pow(this.altura, 2);

        if(imc<20) {
            return -1;
        }
        else if (imc>=20 && imc<=25){
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>17;
    }

    public String toString(){
        return "{ nombre: " + this.nombre + ". dni: " + this.dni + ", edad: " + this.edad + ", peso: " + this.peso + ", altura: " + this.altura + "}";
    }

}
