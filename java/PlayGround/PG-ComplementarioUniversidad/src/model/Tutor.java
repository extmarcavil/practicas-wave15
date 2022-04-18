package model;

import java.util.ArrayList;

public class Tutor extends EstudianteUniversitario implements Docencia {

    ArrayList<EstudianteUniversitario> listaDeAlumnos;

    public Tutor(EstudianteUniversitario alumno) {
        super(alumno.nombre, alumno.matricula, alumno.carrera, alumno.añosCursando);
        System.out.println("Mi nombre es "+ alumno.getNombre() + " y soy tutor en mis tiempos libres");
        listaDeAlumnos = new ArrayList<>();
    }

    @Override
    public void enseñarMateria(EstudianteUniversitario unAlumno) {
        System.out.println("Ayudo con materias a "+ unAlumno.getNombre());
    }
}
