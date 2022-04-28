package universidad.abstractas;

public abstract class Personal {
    String nombre;
    int edad;
    String departamento;

    public Personal(String nombre, int edad, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
    }
}
