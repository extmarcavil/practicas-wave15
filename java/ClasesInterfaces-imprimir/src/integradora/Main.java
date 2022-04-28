package integradora;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        ArrayList<String> habilidades = new ArrayList<String>(){{
            add("Baila");
            add("Canta");
        }};
        Curriculum curriculum = new Curriculum(habilidades, "Juan Pérez", 24, "Escritor");

        Persona revisor = new Persona("Clara Martínez");
        Informes informes = new Informes("Carlos Reyes", "Este es un informe nuevo", 16, revisor);

        PDF pdf = new PDF("Mayerly Dominguez", 56, "El mar azul", "Novela");

        curriculum.imprimir();
        informes.imprimir();
        pdf.imprimir();
    }
}
