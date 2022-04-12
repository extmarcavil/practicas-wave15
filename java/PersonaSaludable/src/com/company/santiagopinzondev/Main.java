package com.company.santiagopinzondev;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos", 21, "3124241");
        Persona persona3 = new Persona("Maria", 23, "34534646", 60, 1.90);

        int imc = persona3.calcularIMC();
        switch (imc) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }
        System.out.println(persona3.toString());
    }
}
