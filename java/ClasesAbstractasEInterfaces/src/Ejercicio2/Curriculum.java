package Ejercicio2;

public class Curriculum implements Imprimible{
    private String nombre;
    private String dni;

    @Override
    public void imprimir() {
        System.out.println("Curriculum vitae de " + nombre + ", dni " + dni + ".");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
