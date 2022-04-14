package ejercicioIntegradorParte1YParte2;

import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    /** Cuidado que este metodo puede dar un null punter exceptio*/
    public static Cliente buscarCliente (List<Cliente> clientes, String dni){
        boolean existe = false;
        Cliente cl = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                cl = cliente;
                existe = true;
                break;
            }
        }

        if (!existe) {
            System.out.println("Usuario no encontrado");
        }

        return cl;
    }

    public static void eliminarCliente (List<Cliente> clientes, String dni){
        boolean existe = false;
        for (Cliente c:clientes) {
            if(c.getDni().equals(dni)){
                clientes.remove(c);
                existe = true;
                break;
            }
        }

        if(existe){
            System.out.println("Usuario eliminado correctamente");
        }else {
            System.out.println("No se enconttro el usuario");
        }

    }

    public static Cliente crearCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Intrpducir el dni");
        String dni2 = sc.nextLine();
        System.out.println("Introducir el nombre ");
        String nombre = sc.nextLine();
        System.out.println("Introducir el apellido");
        String apellido= sc.nextLine();

        Cliente cliente = new Cliente(dni2,nombre,apellido);
        sc.close();
        return cliente;

    }



}
