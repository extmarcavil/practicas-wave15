package com.company;

public class Persona {
    private String nombre;
    private String dni;
    private int edad;
    private double peso;
    private double altura; //esta en m

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        double imc = peso / (altura * altura);

        if(imc < 20)
            return -1;
        else if(imc <= 25)
            return 0;

        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return nombre + " de " + edad + " años, DNI: " + dni + ", mide " + altura + "m y pesa " + peso + "kg";
    }
}
