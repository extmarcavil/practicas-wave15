package com.company;

public class Ejercicio {
    public static void main(String[] args) {
        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 21000; // monto de ejemplo
        double sueldoConAumento;
        // Tu codigo aqui
        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase*1.2;
        }
        else {
            if (sueldoBase > 20.000 && sueldoBase <= 45000){
                sueldoConAumento = sueldoBase*1.1;
            }
            else {
                sueldoConAumento = sueldoBase*1.05;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }
}
