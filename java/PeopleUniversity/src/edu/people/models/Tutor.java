package edu.people.models;

public class Tutor extends Student implements ITeachable {

    public Tutor(String name, String surname, String career) {
        super(name, surname, career);
    }

    @Override
    public void tutorship() {
        System.out.println("El tutor" + super.toString() + " esta dando una tutoria");
    }
}
