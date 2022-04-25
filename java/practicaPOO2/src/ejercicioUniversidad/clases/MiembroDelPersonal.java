package ejercicioUniversidad.clases;

public abstract class MiembroDelPersonal {

    private String nombre;
    private String apellido;
    private String cargo;

    public MiembroDelPersonal(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    public abstract void trabajar();
}
