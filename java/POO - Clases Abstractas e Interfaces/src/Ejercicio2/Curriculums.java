package Ejercicio2;

import java.util.ArrayList;

public class Curriculums implements Imprimible {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    private String nombre;
    private ArrayList<String> habilidades;

    public Curriculums(String nombre, ArrayList<String> habilidades){
        this.nombre = nombre;
        this.habilidades = habilidades;
    }


    @Override
    public void imprimible() {
        System.out.println(nombre);
        for (String h : habilidades){
            System.out.println("-" + h);
        }
    }
}
