package ejercicioUniversidad;

import ejercicioUniversidad.clases.*;


/*
Asuma que queremos modelar personas de una universidad para implementar un sistema de administración de cursos.
Hay diferentes personas involucradas: miembros del personal, estudiantes, profesores, personal de mantenimiento, tutores,
personal de soporte técnico y estudiantes técnicos. Los tutores y los estudiantes técnicos son interesantes: los tutores son
estudiantes que han sido elegidos para enseñar algo y los estudiantes técnicos son estudiantes que han sido seleccionados para
colaborar en el soporte técnico. Realice una jerarquía de tipos (clases e interfaces) que represente esta situación. Reproduce
un escenario donde se muestre qué tipos son clases concretas, clases abstractas e interfaces.
*/

public class EjercicioUniversidad {

    public static void main(String[] args) {

        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Julian", "Vazquez", 3);
        Tutor estudianteTutor = new Tutor("Marina", "Morel", 4);
        Profesor profesor = new Profesor("Mariana", "Gonzalez", "Profesor de Programación I");
        PersonalDeMantenimiento mantenimiento = new PersonalDeMantenimiento("Carlos", "Soto", "Personal de mantenimiento");
        PersonalSoporteTecnico soporte = new PersonalSoporteTecnico("Carlos", "Soto", "Personal de soporte técnico");

        estudianteTecnico.estudiar();
        estudianteTecnico.colaborarEnSoporte();

        estudianteTutor.estudiar();
        estudianteTutor.enseñar();

        profesor.trabajar();
        profesor.enseñar();

        mantenimiento.trabajar();

        soporte.trabajar();
        soporte.colaborarEnSoporte();
    }
}
