import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    ArrayList<Factura> facturas;

    public Cliente(String dni, String nombre, String apellido ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {
        this("","","");
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void cambiarDNI(String dni){
        setDni(dni);
    }

    public void cambiarNombre(String nombre){
        setNombre(nombre);
    }

    public void cambiarApellido(String apellido){
        setApellido(apellido);
    }





    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", facturas=" + facturas +
                '}';
    }
}
