package com.company;

public class Main {

    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaIntermedia = new Persona("Esteban Quito", "000000", 42);
        Persona personaCompleta = new Persona("Esteban Quito", "111111", 24, 65, 1.8);

        System.out.println("El IMC de la persona es:" + personaCompleta.calcularIMC());

        if(personaCompleta.esMayorDeEdad())
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona no es mayor de edad");

        System.out.println(personaCompleta.toString());
    }
}
