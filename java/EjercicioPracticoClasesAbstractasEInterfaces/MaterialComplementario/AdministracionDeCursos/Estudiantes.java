package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.AdministracionDeCursos;

public abstract class Estudiantes {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected int edad;
    protected String Carrera;
    protected int semestreCursando;

    public Estudiantes() {
    }

    public Estudiantes(String nombre, String apellido, String dni, int edad, String carrera, int semestreCursando) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        Carrera = carrera;
        this.semestreCursando = semestreCursando;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public int getSemestreCursando() {
        return semestreCursando;
    }

    public void setSemestreCursando(int semestreCursando) {
        this.semestreCursando = semestreCursando;
    }

    public abstract void irAclases();

    @Override
    public String toString() {
        return "Estudiantes{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", Carrera='" + Carrera + '\'' +
                ", semestreCursando=" + semestreCursando +
                '}';
    }
}
