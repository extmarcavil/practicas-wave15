package integradora;

public class Persona {
    String nombre;
    int edad;
    String tituloUniversitario;

    public Persona(String nombre, int edad, String tituloUniversitario) {
        this.nombre = nombre;
        this.edad = edad;
        this.tituloUniversitario = tituloUniversitario;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTituloUniversitario() {
        return tituloUniversitario;
    }

    public void setTituloUniversitario(String tituloUniversitario) {
        this.tituloUniversitario = tituloUniversitario;
    }
}
