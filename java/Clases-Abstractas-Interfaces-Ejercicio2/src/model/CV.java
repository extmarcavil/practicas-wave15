package model;

import java.util.List;

public class CV extends Documento{
    private Persona persona;
    private List<Habilidad> habilidades;

    public CV(Persona persona, List<Habilidad> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum Vitae: {" +
                "\nDNI: " + persona.getDni() +
                "\nNOMBRE: " + persona.getNombre() +
                "\nEDAD: " + persona.getEdad() +
                "\nHABILIDADES= " + habilidades +
                '}';
    }

    @Override
    public String imprimir() {
        return this.toString();
    }
}
