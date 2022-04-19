package edu.people.models;

public class MantenanceStaff extends Person {

    private String activity;

    public MantenanceStaff(String name, String surname, String activity) {
        super(name, surname);
        this.activity = activity;
    }

    @Override
    public String accessToCollege() {
        return "La persona de mantenimiento " + super.toString() + " esta accediendo a la universidad";
    }
}
