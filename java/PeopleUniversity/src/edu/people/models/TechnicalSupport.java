package edu.people.models;

public class TechnicalSupport extends Person implements ISupportable {

    private String activity;

    public TechnicalSupport(String name, String surname, String activity) {
        super(name, surname);
        this.activity = activity;
    }

    @Override
    public String accessToCollege() {
        return "La persona de soporte tecnico " + super.toString() + " esta accediendo a la universidad";
    }

}
