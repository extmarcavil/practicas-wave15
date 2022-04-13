package ejercicioIntegradorTurismo;

import java.util.ArrayList;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private ArrayList<Localizador> localizadores;
    private boolean aplicaDescuentoCincoPorc = false;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return " Cliente \n{" +
                " DNI = " + dni +
                ", \nNombre = '" + nombre + '\'' +
                ", \nApellido = '" + apellido + '\'' +
                '}';
    }
}
