package main;

import java.util.List;

public class Curriculum implements Imprimir{

    private String nombre;
    private String apellido;
    private int edad;
    private String Domicilio;
    private List<String> listaHabilidades;

    public Curriculum(String nombre, String apellido, int edad, String domicilio, List<String> listaHabilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Domicilio = domicilio;
        this.listaHabilidades = listaHabilidades;
    }

    public Curriculum(){

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(List<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public String toString() {
        return "Curriculum de " + nombre + " " + apellido +
                "\nEdad: " + edad +
                "\nDomicilio: " + Domicilio +
                "\nHabilidades: " + listaHabilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
