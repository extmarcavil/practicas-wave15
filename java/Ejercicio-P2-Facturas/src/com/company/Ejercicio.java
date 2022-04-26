package com.company;

import java.util.LinkedList;
import java.util.List;

public class Ejercicio {
    public static void main(String[] args) {

        // Este tipo de dato sera visto en la siguiente clase en vivo
        List<String> mensajeStrings = new LinkedList<>();

        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        //Tu codigo aqui
        for (int i = 0; i<serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 1500;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500 + 700;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: " + totalFactura);
            }
        }
    }

}
