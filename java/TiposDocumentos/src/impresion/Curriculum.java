package impresion;

import java.util.List;

public class Curriculum implements Impresion {

    private String nombre;
    private String apellido;
    private String dni;
    private String profesion;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, String profesion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }

    @Override
    public void mostrar() {
        String impresion = "Nombre: " + nombre + "\tApellido: " + apellido + "\tDNI: " + dni + "\tProfession: " + profesion;
        impresion += "\nHabilidades\n";
        for (String habilidad : habilidades) {
            impresion += "\t" + habilidad + "\n";
        }
        System.out.println(impresion);
    }
}
