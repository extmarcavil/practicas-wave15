package com.company;

import com.company.clases.Persona;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese Nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese edad");
        int edad = teclado.nextInt();
        System.out.println("Ingrese DNI");
        String dni = teclado.next();
        System.out.println("Ingrese Peso");
        float peso = teclado.nextFloat();
        System.out.println("Ingrese Altura");
        float altura = teclado.nextFloat();
        System.out.println();

        Persona persona = new Persona();
        Persona persona2 = new Persona(nombre, edad, dni, peso, altura);
        Persona persona3 = new Persona(nombre, edad, dni);

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("DNI: " + dni);
        System.out.println("Peso en kg: " + peso);
        System.out.println("Altura en metros: " + altura);
        persona2.esMayorDeEdad(edad);
        persona2.cacularIMC(peso, altura);
    }
}
