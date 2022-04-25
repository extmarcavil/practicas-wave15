package ejercicioUniversidad.clases;

import ejercicioUniversidad.interfaces.IDocencia;

public class Tutor extends Estudiante implements IDocencia {

    public Tutor(String nombre, String apellido, int añoCursando) {
        super(nombre, apellido, añoCursando);
    }

    @Override
    public void enseñar() {
        System.out.println("Puedo enseñar en la universidad.");
    }

    @Override
    public void estudiar() {
        System.out.println("Soy un estudiante tutor y estudio en la universidad.");
    }
}
