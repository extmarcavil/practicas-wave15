package edu.people.models;

public class Staff extends Person {

    private String position;

    public Staff(String name, String surname, String position) {
        super(name, surname);
        this.position = position;
    }

    @Override
    public String accessToCollege() {
        return "El staff " + super.toString() + "con el cargo " + this.position + " esta accediendo a la unuversidad";
    }
}
