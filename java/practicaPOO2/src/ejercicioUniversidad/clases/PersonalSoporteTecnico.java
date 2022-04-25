package ejercicioUniversidad.clases;

import ejercicioUniversidad.interfaces.ISoporte;

public class PersonalSoporteTecnico extends MiembroDelPersonal implements ISoporte {

    public PersonalSoporteTecnico(String nombre, String apellido, String cargo) {
        super(nombre, apellido, cargo);
    }

    @Override
    public void colaborarEnSoporte() {
        System.out.println("Trabajo en el área de soporte de la universidad.");
    }

    @Override
    public void trabajar() {
        System.out.println("Soy del personal de soporte técnico y trabajo en la universidad.");
    }
}
