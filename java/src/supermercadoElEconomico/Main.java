package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Cliente> listaClientes = new ArrayList<>();;
    public static void main(String[] args) {

        int dni;
        Cliente c1 = new Cliente(38,"Lisandro","Lopez");
        Cliente c2 = new Cliente(35,"Lionel","Messi");
        Cliente c3 = new Cliente(32,"Diego","Milito");

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){

            System.out.println("\n1. Crear cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Consultar cliente");
            System.out.println("4. Salir");

            System.out.print("\nEscribe una de las opciones: ");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    crearCliente(c1);
                    crearCliente(c2);
                    crearCliente(c3);
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    consultarGenerico();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }

        }

    }

    public static void crearCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public static void consultar(){
        listaClientes.forEach(System.out::println);
    }

    public static void consultar(int dni){
        listaClientes.stream().filter(x -> x.getDni() == dni).forEach(System.out::println);
        List<Cliente> listaTemp = listaClientes.stream()
                .filter(x -> x.getDni() == dni).collect(Collectors.toList());
        if(listaTemp.size() == 0)
            System.out.println("DNI no encontrado.");

    }

    public static void eliminarCliente(){

        Scanner sn = new Scanner(System.in);

        System.out.print("\nIngrese DNI: ");
        int dni = sn.nextInt();

        List<Cliente> listaTemp = listaClientes.stream()
                .filter(x -> x.getDni() == dni).collect(Collectors.toList());
        if(listaTemp.size() == 0) {
            System.out.println("DNI no encontrado.");
        }else{
            listaClientes.removeIf(p -> p.getDni() == dni);
        }
    }

    public static void consultarGenerico(){
        int dni;
        Scanner sn = new Scanner(System.in);
        System.out.println("\n1. Consultar todos");
        System.out.println("2. Consultar por DNI");
        System.out.println("\nEscribe una de las opciones");
        int opcion = sn.nextInt();
        switch(opcion){
            case 1:
                consultar();
                break;
            case 2:
                System.out.print("\nIngrese DNI: ");
                dni = sn.nextInt();
                consultar(dni);
                break;
            default:
                System.out.println("Solo números entre 1 y 2");
        }
    }

}
