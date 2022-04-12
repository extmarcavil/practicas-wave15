package carreraSelva;

public class Participante {
    String nombre;
    String apellido;
    int dni;
    int edad;
    int celular;
    int telEmergencia;
    String grupoSanguineo;
    String categoria;

    public Participante(String nombre, String apellido, int dni, int edad, int celular, int telEmergencia, String grupoSanguineo, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.telEmergencia = telEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getTelEmergencia() {
        return telEmergencia;
    }

    public void setTelEmergencia(int telEmergencia) {
        this.telEmergencia = telEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
