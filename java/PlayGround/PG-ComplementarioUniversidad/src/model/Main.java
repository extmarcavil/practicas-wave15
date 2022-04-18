package model;

public class Main {

    public static void main(String[] args) {

        String materiaDeMatematica = "AnalisisMatematico";

        EstudianteUniversitario estudiante1 = new EstudianteUniversitario("Ramiro","95887","Ingenieria",2);
        EstudianteUniversitario estudiante2 = new EstudianteUniversitario("Santiago","93939","Ingenieria",2);
        Profesor profesor1 = new Profesor("Ezequiel","78443",materiaDeMatematica,"JTP");
        Profesor profesor2 = new Profesor("Manuel","84743","Quimica","Jefe De Catedra");
        SoporteTecnico tecnico = new SoporteTecnico("Eduardo", "93894839","DataCenter");

        estudiante1.irALaUniversidad();
        profesor1.irALaUniversidad();
        profesor2.irALaUniversidad();

        estudiante1.inscribirEnMateria(materiaDeMatematica);

        profesor1.imprimirSiEsDocenteDelAlumno(estudiante1);
        profesor2.imprimirSiEsDocenteDelAlumno(estudiante1);

        Tutor tutor = new Tutor(estudiante1);
        tutor.enseñarMateria(estudiante2);

        EstudiantesTecnicos unEstudianteTecnico = new EstudiantesTecnicos(estudiante2);
        unEstudianteTecnico.colaborarCon(tecnico);


    }

}
