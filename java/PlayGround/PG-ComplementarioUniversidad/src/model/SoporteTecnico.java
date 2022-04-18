package model;

public class SoporteTecnico extends TrabajadorUniversitario {

    String areaDeTrabajo;

    public String getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    public SoporteTecnico(String nombre, String matricula, String areaDeTrabajo) {
        super(nombre, matricula);
        this.areaDeTrabajo = areaDeTrabajo;
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajo arreglando computadoras");
    }

    @Override
    public void irALaUniversidad() {
        System.out.println("Voy a la universidad a gestionar los sistemas");
    }


}
