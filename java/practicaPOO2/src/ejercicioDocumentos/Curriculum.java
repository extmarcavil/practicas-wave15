package ejercicioDocumentos;

import java.util.ArrayList;

public class Curriculum extends Documento {
    private Persona persona;
    private ArrayList<String> habilidades;

    public Curriculum(Persona persona, ArrayList<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }
}
