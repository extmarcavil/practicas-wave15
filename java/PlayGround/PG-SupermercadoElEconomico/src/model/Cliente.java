package model;

public class Cliente {

    private String DNI;
    private String nombre;
    private String apellido;

    public Cliente(String DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public boolean hasSameDNI(String dniToSearch){
        return (DNI.equals(dniToSearch));
    }

    public void imprimirDatos() {
        System.out.printf("\t %-15.15s %-15.15s %-15.15s \n", this.nombre, this.apellido,this.DNI);
    }
}
