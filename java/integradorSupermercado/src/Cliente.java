public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + dni;
    }

    public String getDni() {
        return dni;
    }
}
