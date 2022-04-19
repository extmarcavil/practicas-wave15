package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.AdministracionDeCursos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");

        EstudiantesTecnicos estTec1 = new EstudiantesTecnicos();
        estTec1.setNombre("Marcelo");
        System.out.println("El estudiante: "+estTec1.nombre);
        estTec1.irAclases();
        estTec1.darSoporteTecnico();

        System.out.println("-------------------------------------------");

        Tutores tutor1 = new Tutores();
        tutor1.setNombre("Kevin");
        System.out.println("El estudiante: " + tutor1.getNombre());
        tutor1.irAClases();
        tutor1.enseñarJava();

        System.out.println("-------------------------------------------");

        PersonalDeMantenimiento persDeMant1 = new PersonalDeMantenimiento();
        persDeMant1.setNombre("Miguel");
        System.out.println("El personal de Mantenimiento: "+persDeMant1.getNombre());
        persDeMant1.irATrabajar();
        persDeMant1.realizarMantencion();

        System.out.println("-------------------------------------------");


    }
}
