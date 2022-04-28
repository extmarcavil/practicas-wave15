package abstractasInterfaces.ejercicio2.entity;

import java.util.ArrayList;

public class Person {

    ArrayList<Hability> habilities;

    public Person(ArrayList<Hability> habilities) {
        this.habilities = habilities;
    }

    public ArrayList<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(ArrayList<Hability> habilities) {
        this.habilities = habilities;
    }
}
