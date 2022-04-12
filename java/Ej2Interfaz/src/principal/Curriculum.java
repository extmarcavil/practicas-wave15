package principal;

public class Curriculum implements Imprimir{
    private String nombre;
    private String telefono;
    private String localidad;
    private String experiencia;

    public Curriculum(String nombre, String telefono, String localidad, String experiencia) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }


    @Override
    public String imprimirDoc() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", localidad='" + localidad + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }

}
