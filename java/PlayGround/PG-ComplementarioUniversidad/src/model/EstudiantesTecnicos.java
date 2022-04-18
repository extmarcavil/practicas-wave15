package model;

import java.util.ArrayList;

public class EstudiantesTecnicos extends EstudianteUniversitario{

    String areaAyudada;

    public EstudiantesTecnicos(EstudianteUniversitario alumno) {
        super(alumno.nombre, alumno.matricula, alumno.carrera, alumno.añosCursando);
        System.out.println("Mi nombre es "+ alumno.getNombre() + " y soy ayudante tecnico en mis tiempos libres");
        this.areaAyudada = "Ninguna";
    }

    public void colaborarCon(SoporteTecnico unTecnico){
        this.areaAyudada = unTecnico.getAreaDeTrabajo();
        System.out.println("Ahora colaborare con "+ unTecnico.getNombre() + " en el area de " + this.areaAyudada);
    }
}
