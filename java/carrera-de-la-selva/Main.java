package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarreraSelva carrera = new CarreraSelva();
        String inscripto1 = carrera.inscripcion(38166153, "Alan", "Gimenez", 17, 1122558261, "A", "medio");
        System.out.println(inscripto1);
        String inscripto2 = carrera.inscripcion(38383838, "Javier", "Garcia", 33, 1122558261, "A", "medio");
        System.out.println(inscripto2);
        String listadoInscriptos = carrera.obtenerInscriptos("medio");
        System.out.println(listadoInscriptos);
    }






}
