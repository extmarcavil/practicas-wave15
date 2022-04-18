package model;

public abstract class TrabajadorUniversitario extends Universitario{

    double salario;
    String cargo;

    protected TrabajadorUniversitario(String nombre, String matricula) {
        super(nombre, matricula);
        this.salario = 1000;
        this.cargo = "";
    }

    public abstract void trabajar();


}
