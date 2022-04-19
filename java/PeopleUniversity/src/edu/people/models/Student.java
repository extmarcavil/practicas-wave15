package edu.people.models;

public class Student extends Person {

    private String career;

    public Student(String name, String surname, String career) {
        super(name, surname);
        this.career = career;
    }

    @Override
    public String accessToCollege() {
        return "El estudiante " + super.toString() + " de la carrera" + career +" esta accediendo a la universidad";
    }
}
