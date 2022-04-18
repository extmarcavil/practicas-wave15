package ejercicioAgencia;

import java.util.ArrayList;

public class Cliente {
    private long dni;
    private String nombre;

    public Cliente(long dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
