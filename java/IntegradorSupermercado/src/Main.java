import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Cliente cli1 = new Cliente(34567876L, "Francisco", "Giaccaglia");
        Cliente cli2 = new Cliente(20534573L, "Juana", "Rodriguez");
        Cliente cli3 = new Cliente(56576575L, "Leo", "Messi");

        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente.add(cli1);
        listaCliente.add(cli2);
        listaCliente.add(cli3);

        for(Cliente cli : listaCliente){
            System.out.println("DNI: " + cli.getDni() + ". Nombre y apellido: " + cli.getNombre() + " " + cli.getApellido());
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea borrar");
        Long clienteBorrado = keyboard.nextLong();

        Boolean bandera = false;
        for(Cliente cliente: listaCliente){
            if(cliente.getDni().equals(clienteBorrado)){
                listaCliente.remove(cliente);
                bandera = true;
                break;
            }
        }
        if(!bandera){
            System.out.println("No se encontró ningún cliente asociado al DNI");
        }
        else{
            System.out.println("Cliente asociado al DNI borrado correctamente");
        }

        System.out.println("Ingrese el DNI del cliente buscado");
        Long clienteBuscado = keyboard.nextLong();

        bandera = false;
        for(Cliente cliente : listaCliente){
            if(cliente.getDni().equals(clienteBuscado)){
                System.out.println("El cliente buscado tiene la siguiente información: ");
                System.out.println("DNI: " + cliente.getDni() + ". Nombre y apellido: " + cliente.getNombre() + " " + cliente.getApellido());
                break;
            }
        }
        if(!bandera){
            System.out.println("Cliente no encontrado");
        }
    }
}
