package ClasesAbstractasEInterfaces.Ej2.Clases;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {

    private String nombre;
    private String apellido;
    private String email;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String email, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.habilidades = habilidades;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getEmail(){
        return this.email;
    }

    public List<String> getHabilidades(){
        return this.habilidades;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setHabilidades(ArrayList<String> habilidades){
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(getNombre()).append("\n");
        sb.append("Apellido: ").append(getApellido()).append("\n");
        sb.append("Email: ").append(getEmail()).append("\n");
        sb.append("Habilidades: ").append(getHabilidades()).append("\n");
        return sb.toString();
    }
}
