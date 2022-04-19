package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.AdministracionDeCursos;

public class PersonalDeMantenimiento extends MiembrosDelPersonal {
    public PersonalDeMantenimiento(String nombre, String apellido, String dni, int edad) {
        super(nombre, apellido, dni, edad);
    }

    public PersonalDeMantenimiento() {

    }

    @Override
    public void irATrabajar() {
        System.out.println("Va a trabajar");
    }
    public void realizarMantencion(){
        System.out.println("Da soporte de mantenimineto");
    }
}
