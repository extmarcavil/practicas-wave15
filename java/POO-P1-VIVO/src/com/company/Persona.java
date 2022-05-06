package com.company;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private double peso;
    private double altura;


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


    public int calcularImc() {

        int valor;
        double indice = peso / (Math.pow(altura, 2));
        if (indice < 20) {
            valor = -1;
        } else if (indice >= 20 && indice <= 25) {
            valor = 0;
        } else {
            valor = 1;
        }
        return valor;
    }

    public boolean esMayorDeEdad(){
         return  edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
