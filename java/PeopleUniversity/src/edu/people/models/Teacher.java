package edu.people.models;

public class Teacher extends Person {

    private String subject;

    public Teacher(String name, String surname, String subject) {
        super(name, surname);
        this.subject = subject;
    }

    @Override
    public String accessToCollege() {
        return "El profesor/a " + super.toString() + " esta accediendo a la universidad";
    }
}
