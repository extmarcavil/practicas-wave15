package com.company.clases;

import java.lang.Math;

public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

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

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int cacularIMC(float peso, float altura){
        double altura_cuadrado = Math.pow(altura, 2);
        float imc = (float) (peso/(altura_cuadrado));
        if (imc < 20){
            System.out.println("Índice de masa corporal (IMC) por debajo de 20 | Peso Bajo");
            return -1;
        } else
            if (imc >= 20 && imc <= 25 ){
                System.out.println("Índice de masa corporal (IMC) entre 20 y 25 inclusive | Peso Saludable");
                return 0;
            }
         else {
                System.out.println("Índice de masa corporal (IMC) mayor de 25 | Sobrepeso");
                return 1;
        }
    }

    public boolean esMayorDeEdad(int edad){
        if (edad >= 18){
            System.out.println("Persona mayor de edad");
            return true;
        } else {
            System.out.println("Persona menor de edad");
            return false;
        }
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
