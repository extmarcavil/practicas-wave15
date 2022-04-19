package entidades;

public class Cliente {
    private String name;
    private int dni;
    private String surname;

    @Override
    public String toString() {
        return "Hola, soy el cliente " +name + " " + surname + " y mi DNI es " + dni;
    }

    public Cliente() {
    }

    public Cliente(String name, int dni, String surname) {
        this.name = name;
        this.dni = dni;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
