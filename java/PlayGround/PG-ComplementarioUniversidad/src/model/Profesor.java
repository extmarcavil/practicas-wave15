package model;

import java.util.ArrayList;

public class Profesor extends TrabajadorUniversitario implements Docencia {

    ArrayList<String> catedrasACargo;
    String cargo;

    public Profesor(String nombre, String matricula, String nuevaCatedra, String cargo) {
        super(nombre,matricula);
        this.catedrasACargo = new ArrayList<>() ;
        this.catedrasACargo.add(nuevaCatedra);
        this.cargo = cargo;
    }

    @Override
    public void irALaUniversidad() {
        System.out.println("Voy a trabajar a la universidad de profesor");
    }

    @Override
    public void enseñarMateria(EstudianteUniversitario unAlumno) {
        System.out.println("Enseño materias a "+ unAlumno.getNombre());
    }

    public boolean esProfesorDe(EstudianteUniversitario unAlumno){
        for( String materia: catedrasACargo){
            if( unAlumno.estaInscriptoEn(materia) == true)
                return true;
        }
        return false;
    }

    public void imprimirSiEsDocenteDelAlumno(EstudianteUniversitario unAlumno) {
        System.out.println("El profesor "+
                this.getNombre() +
                (this.esProfesorDe(unAlumno)? " es ": " no es ") +
                "docente del alumno "+
                unAlumno.getNombre()
        );
    }

    @Override
    public void trabajar() {
        System.out.println("Enseño mis materias");
    }
}
