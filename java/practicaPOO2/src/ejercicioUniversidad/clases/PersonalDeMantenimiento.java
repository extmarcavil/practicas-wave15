package ejercicioUniversidad.clases;

public class PersonalDeMantenimiento extends MiembroDelPersonal {


    public PersonalDeMantenimiento(String nombre, String apellido, String cargo) {
        super(nombre, apellido, cargo);
    }

    @Override
    public void trabajar() {
        System.out.println("Soy del personal de mantenimiento y trabajo en la universidad.");
    }
}
