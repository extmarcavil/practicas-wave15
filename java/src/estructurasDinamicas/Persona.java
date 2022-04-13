package estructurasDinamicas;

public class Persona {
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getCelular() {
        return celular;
    }

    public int getNro_emergencia() {
        return nro_emergencia;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int nro_emergencia;
    private String grupo_sanguineo;

    public Persona(int dni, String nombre, String apellido, int edad, int celular, int nro_emergencia, String grupo_sanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nro_emergencia = nro_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

}
