package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Cliente(){

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cliente buscarXDni(String dni, List<Cliente> listado) {

        Cliente cliente = listado.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .get();
        return cliente;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDni: " + dni;
    }

}
