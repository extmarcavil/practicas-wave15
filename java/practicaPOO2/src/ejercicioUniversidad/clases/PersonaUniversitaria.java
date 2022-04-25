package ejercicioUniversidad.clases;

public abstract class PersonaUniversitaria {

    private String nombre;
    private String apellido;

    public PersonaUniversitaria(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public abstract void presentarse();
}
