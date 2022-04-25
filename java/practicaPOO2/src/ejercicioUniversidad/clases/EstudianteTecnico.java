package ejercicioUniversidad.clases;

import ejercicioUniversidad.interfaces.ISoporte;

public class EstudianteTecnico extends Estudiante implements ISoporte {


    public EstudianteTecnico(String nombre, String apellido, int añoCursando) {
        super(nombre, apellido, añoCursando);
    }

    @Override
    public void colaborarEnSoporte() {
        System.out.println("Colaboro en el área de soporte de la universidad.");
    }

    @Override
    public void estudiar() {
        System.out.println("Soy un estudiante técnico y estudio en la universidad.");
    }
}
