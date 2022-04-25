package ejercicioUniversidad.clases;

import java.util.ArrayList;

public abstract class Estudiante {

    private String nombre;
    private String apellido;
    private int añoCursando;

    public Estudiante(String nombre, String apellido, int añoCursando) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoCursando = añoCursando;
    }

    public abstract void estudiar();
}
