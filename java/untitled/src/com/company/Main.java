package com.company;

public class Main {

    public static void main(String[] args) {


            String dni = "12345678"; // dni de ejemplo
            double sueldoBase = 21000; // monto de ejemplo
            double sueldoConAumento=0;


            if (sueldoBase <= 20000) {
                sueldoConAumento= sueldoBase+ (sueldoBase * 0.2);
            }
            else {
                if (sueldoBase>20000 && sueldoBase<=45000){
                    sueldoConAumento= sueldoBase + (sueldoBase * 0.1);
                }
                else {
                    if(sueldoBase>45000){
                        sueldoConAumento= sueldoBase +(sueldoBase * 0.05);
                    }
                }
            }

                System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
            }





}
