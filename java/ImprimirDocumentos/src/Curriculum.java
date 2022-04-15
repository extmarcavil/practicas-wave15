import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimir{

    private String nombreCompleto;
    private Integer edad;
    private Integer dni;
    private String ciudad;
    private String profesion;
    List<String> habilidades = new ArrayList<>();

    public Curriculum(String nombreCompleto, Integer edad, Integer dni, String ciudad, String profesion, List<String> habilidades) {

        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.dni = dni;
        this.ciudad = ciudad;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {

        System.out.println("Nombre: " + nombreCompleto + ". Edad: " + edad + ". Dni: " + dni + ". Nacido/a en: " +
                ciudad + ". Título: " + profesion + ". Aptitudes laborales: " + habilidades);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
