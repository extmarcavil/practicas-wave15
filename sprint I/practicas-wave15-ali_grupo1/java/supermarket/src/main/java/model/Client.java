package model;

import java.util.Objects;

public class Client {

    private final String dni;
    private final String firstName;
    private final String lastName;

    public Client(String dni, String firstName, String lastName) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return dni.equals(client.dni) && firstName.equals(client.firstName) && lastName.equals(client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, firstName, lastName);
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "dni='" + dni + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
