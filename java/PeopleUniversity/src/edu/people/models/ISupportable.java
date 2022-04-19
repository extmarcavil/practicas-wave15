package edu.people.models;

public interface ISupportable {

    default void assist() {
        System.out.println("Prestando servicio tecnico");
    }
}
