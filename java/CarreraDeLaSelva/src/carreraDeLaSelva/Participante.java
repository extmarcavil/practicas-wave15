package carreraDeLaSelva;

public class Participante {
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;

    public String calcularMonto(String circuito) {
        Integer monto = 0;
        if (circuito.equals("chico")) {
            monto = this.getEdad() < 18 ? 1300 : 1500;
        } else if (circuito.equals("medio")) {
            monto = this.getEdad() < 18 ? 2000 : 2500;
        } else {
            monto = 2800;
        }
        return monto.toString();
    }

    public String toString() {
        return "{ DNI: " + this.getDni() + ", NOMBRE: " + this.getNombre() + " " + this.getApellido() + ", EDAD: " + this.getEdad() + " }";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroDeEmergencia() {
        return numeroDeEmergencia;
    }

    public void setNumeroDeEmergencia(String numeroDeEmergencia) {
        this.numeroDeEmergencia = numeroDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
