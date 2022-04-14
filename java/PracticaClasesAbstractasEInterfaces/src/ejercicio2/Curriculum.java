package ejercicio2;

public class Curriculum implements Imprimir{

    private String nombre;
    private String apellido;
    private String dni;
    private String profesion;
    private String habilidaddes;

    public Curriculum(String nombre, String apellido, String dni, String profesion, String habilidaddes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.profesion = profesion;
        this.habilidaddes = habilidaddes;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getHabilidaddes() {
        return habilidaddes;
    }

    public void setHabilidaddes(String habilidaddes) {
        this.habilidaddes = habilidaddes;
    }

    @Override
    public void imprimir() {
        System.out.println("El profesional " + nombre+ " " + apellido + " profesional en " + profesion
                +" tines las siguientes habilidades : " + habilidaddes);
    }
}
