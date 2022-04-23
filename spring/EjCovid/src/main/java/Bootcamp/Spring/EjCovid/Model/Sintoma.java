package Bootcamp.Spring.EjCovid.Model;

public class Sintoma {
    private int codigo, nivel_de_gravedad;
    private String nombre;

    public Sintoma(int codigo, int nivel_de_gravedad, String nombre) {
        this.codigo = codigo;
        this.nivel_de_gravedad = nivel_de_gravedad;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo=" + codigo +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(int nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
