package abstraccionPractico2;

import java.util.List;

public class Curriculum implements Imprimible{
    String nombre;
    int edad;
    String dni;
    List<String> skills;

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", skills=" + skills +
                '}';
    }

    public void imprimirCV(){
        Imprimible.imprimir(toString());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Curriculum(String nombre, int edad, String dni, List<String> skills) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.skills = skills;
    }
}
