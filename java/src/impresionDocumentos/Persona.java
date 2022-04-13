package impresionDocumentos;

import java.util.ArrayList;

public class Persona {

    private int dni;
    private String nombre;
    private String apellido;
    private ArrayList<String> habilidades;


    public Persona(int dni, String nombre, String apellido, ArrayList<String> habilidades) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return
                "DNI " + dni +
                " Nombre '" + nombre + '\'' +
                " Apellido '" + apellido + '\'' +
                " Habilidades " + habilidades;
    }
}
