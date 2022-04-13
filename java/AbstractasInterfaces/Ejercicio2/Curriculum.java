package AbstractasInterfaces.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements TipoDocumento {

    private Persona persona;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return persona.getNombre() + " " + persona.getApellido() + " tiene " + habilidades.size() + " habilidades";
    }
}
