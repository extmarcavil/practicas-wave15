package com.company.santiagopinzondev;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = this.peso/(Math.pow(this.altura, 2));
        if (imc < 20)
            return -1;
        else if (20 <= imc && 25 >= imc)
            return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad>18?true:false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
