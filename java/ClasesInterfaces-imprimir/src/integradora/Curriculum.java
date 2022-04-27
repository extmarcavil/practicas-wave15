package integradora;

import java.util.ArrayList;

public class Curriculum extends Persona implements Imprimible{

    ArrayList<String> habilidades = new ArrayList<>();

    public Curriculum(ArrayList<String> habilidades, String nombre, int edad, String tituloUniversitario) {
        super(nombre, edad, tituloUniversitario);
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("---Curriculum---");
        System.out.println("Autor -> Nombre: " + getNombre() + " Edad: " + getEdad() + " Titulo universitario: " + getTituloUniversitario());
        System.out.println("Habilidades: ");
        for (String habilidad: habilidades) {
            System.out.println("* " + habilidad);
        }
    }
}
