package Ejercicio2;

import java.util.List;

public class Curriculum {

    private String nombre;
    private int edad;
    private String carrera;
    private List<String> habilidades;


    public Curriculum(String nombre, int edad, String carrera, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.habilidades = habilidades;
    }
}
