package clasesAbstractasEinterfaces2;

import java.util.ArrayList;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    ArrayList<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre + ", apellido:" + apellido);
        for(String habilidad : habilidades){
            System.out.println("Habilidad : " + habilidad);
        }
    }
}
