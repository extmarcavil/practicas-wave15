package com.company;

public class Main {

    public static void main(String[] args) {

        Persona people = new Persona();
        Persona people1 = new Persona("Pedro", "1234", 20);
        Persona people2 = new Persona("Pedro2", "12345667", 25, 61.0, 1.70);

        //Persona people3 = new Persona("Pedro3", 25);


        System.out.println(people2.calcularImc());

        switch (people2.calcularImc()) {
            case -1:
                System.out.println("Bajo PESO");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("no existe");
        }

        System.out.println(people2.calcularImc());
        System.out.println(people2);


    }
}
