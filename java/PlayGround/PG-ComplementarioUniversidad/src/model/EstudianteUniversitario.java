package model;

import java.util.ArrayList;

public class EstudianteUniversitario extends Universitario{

    String carrera;
    int añosCursando;
    ArrayList<String> materiasAnotadas;

    public EstudianteUniversitario(String nombre, String matricula, String carrera, int añosCursando) {
        super(nombre, matricula);
        this.carrera = carrera;
        this.añosCursando = añosCursando;
        this.materiasAnotadas = new ArrayList<>();
    }

    public void inscribirEnMateria(String nuevaMateria) {
        this.materiasAnotadas.add(nuevaMateria);
    }

    @Override
    public void irALaUniversidad() {
        System.out.println("Voy a la universidad a aprender");
    }

    public boolean estaInscriptoEn(String materia){
        return materiasAnotadas.stream().anyMatch((String x)->x.equals(materia));
    }
}
