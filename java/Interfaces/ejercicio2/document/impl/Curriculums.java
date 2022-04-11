package abstractasInterfaces.ejercicio2.document.impl;

import abstractasInterfaces.ejercicio2.document.Document;
import abstractasInterfaces.ejercicio2.entity.Hability;
import abstractasInterfaces.ejercicio2.entity.Person;

public class Curriculums implements Document {

    Person person;

    public Curriculums(Person person) {
        this.person = person;
    }

    @Override
    public String print() {
        String prnt = "--- Curriculum --- \n" +
                "La persona tiene las siguientes habilidades: ";
        for(Hability hab : this.person.getHabilities()) {
            prnt += hab.getName() + " ";
        }
        return prnt + "\n";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
