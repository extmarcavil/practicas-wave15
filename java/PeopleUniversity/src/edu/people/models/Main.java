package edu.people.models;

public class Main {

    public static void main(String[] args) {
        MantenanceStaff mantenanceStaff = new MantenanceStaff("Raul", "Ramirez", "Vigilar");
        System.out.println(mantenanceStaff.accessToCollege());

        Student student = new Student("Martin", "Vega", "Ing Industrital");
        System.out.println(student.accessToCollege());

        TechnicalStudent student1 = new TechnicalStudent("Fiona", "Delgado", "Danza");
        System.out.println(student1.accessToCollege());
        student1.assist();

        Tutor student2 = new Tutor("Marta", "Belen", "Artes");
        System.out.println(student2.accessToCollege());
        student2.tutorship();

    }
}
