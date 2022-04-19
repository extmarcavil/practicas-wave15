package ejercicioImpresora;

import java.util.ArrayList;

public class Curriculum {
    private String nombre;
    private String apellido;
    private ArrayList habilidades;

    public Curriculum(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
