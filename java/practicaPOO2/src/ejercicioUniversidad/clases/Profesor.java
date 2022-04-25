package ejercicioUniversidad.clases;

import ejercicioUniversidad.interfaces.IDocencia;

public class Profesor extends MiembroDelPersonal implements IDocencia {

    public Profesor(String nombre, String apellido, String cargo) {
        super(nombre, apellido, cargo);
    }

    @Override
    public void enseñar() {
        System.out.println("Enseño en la universidad.");
    }

    @Override
    public void trabajar() {
        System.out.println("Soy un profesor y trabajo en la universidad.");
    }
}
