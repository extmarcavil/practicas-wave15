package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.AdministracionDeCursos;

public class Tutores extends Estudiantes implements Profesores {
    @Override
    public void irAclases() {
        System.out.println("Va a clases");
    }

    @Override
    public void irAClases() {
        System.out.println("Va a la clase");
    }

    @Override
    public void enseñarJava() {
        System.out.println("Enseña Java");
    }

    @Override
    public void enseñarSprint() {
        System.out.println("Enseña Sprint");
    }

    @Override
    public void enseñarGit() {
        System.out.println("Enseña Git");
    }
}
