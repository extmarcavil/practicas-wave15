package Bootcamp.Spring.EjCovid.Model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id, edad;
    private String nombre, apellido;
    private List<Sintoma> sintomas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Persona(int id, int edad, String nombre, String apellido, List<Sintoma> sintomas) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sintomas=" + sintomas +
                '}';
    }
}
