package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.AdministracionDeCursos;

public class EstudiantesTecnicos extends Estudiantes implements PersonalDeSoporteTecnico {
    @Override
    public void irAclases() {
        System.out.println("Va clases");
    }

    @Override
    public void darSoporteTecnico() {
        System.out.println("Da soporte tecnico");
    }
}
