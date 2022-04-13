package principal;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private Integer dni;


    public Cliente(String nombres, String apellido, Integer dni) {
        this.nombre = nombres;
        this.apellido = apellido;
        this.dni = dni;

    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                " nombres='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
