package model;

public class PersonalAdministrativo extends TrabajadorUniversitario  {

    String departamento;

    public PersonalAdministrativo(String nombre,String matricula,String departamento) {
        super(nombre,matricula);
        this.departamento = departamento;
    }

    @Override
    public void irALaUniversidad() {
        System.out.println("Voy a la universidad a trabajar de administrativo");
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajo en el departamento "+ this.departamento);
    }
}
