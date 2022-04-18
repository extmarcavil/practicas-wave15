import implementacion.ClienteImplement;
import implementacion.FacturaImplement;
import implementacion.ItemImplement;
import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Crear 3 clientes y guardarlos en una collection.
        Cliente c1 = new Cliente("1111111", "Juan", "Perez");
        Cliente c2 = new Cliente("2222222", "Jose", "Gomez");
        Cliente c3 = new Cliente("3333333", "Lucia", "Lopez");

        ClienteImplement cImp = new ClienteImplement();
        FacturaImplement fImp = new FacturaImplement();
        ItemImplement iImp = new ItemImplement();

        //PARTE 1
//        List<Cliente> clientes = new ArrayList<Cliente>();
//        clientes.add(c1);
//        clientes.add(c2);
//        clientes.add(c3);

        //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos
//        listaClientes(clientes);

        //PARTE 2
        //guardar cliente
        cImp.save(c1);
        cImp.save(c2);
        cImp.save(c3);
        //mostrar cliente
        cImp.mostrar();

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir
        //todos los clientes restantes.
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese DNI del cliente a borrar");
        String dni = teclado.nextBigInteger().toString();
//        boolean bandera = false;

        //PARTE 1
//        for (Cliente c:clientes) {
//            if(c.getDni().equals(dni)){
//                clientes.remove(c);
//                bandera = true;
//                break;
//            }
//        }

//        if(bandera) {
//            System.out.println("👍 Cliente eliminado de la lista:");
//            listaClientes(clientes);
//        } else {
//            System.out.println("No se pudo encontrar el cliente");
//        }


        //PARTE II - mismo enunciado ***********************************
        cImp.eliminar(dni);

        //*******************************************

        //Solicitar por teclado un número de dni de un cliente para buscarlo.
        //En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario,
        // mostrar un mensaje que informe dicha situación.

        System.out.println("Ingrese DNI del cliente a buscar");
        String dniBuscar = teclado.nextBigInteger().toString();//
        //PARTE II
        cImp.buscar(dniBuscar);

        //PARTE I
//        bandera = false;

//        for (Cliente c:clientes) {
//            if(c.getDni().equals(dniBuscar)){
//                System.out.println("Cliente encontrado: ");
//                System.out.println("DNI: " + c.getDni() + " - Nombre: " + c.getNombre() + " - Apellido: " + c.getApellido());
//                bandera = true;
//                break;
//            }
//        }

//        if(!bandera){
//            System.out.println("El cliente no pudo ser encontrado...");
//        }





        //Extra
        System.out.println("Metodo traerTodos() de clientes");
        System.out.println(cImp.traerTodos());
    }


    //PARTE 1
//    public static void listaClientes(List<Cliente> clientes){
//        for (Cliente c:clientes) {
//            System.out.println("DNI: " + c.getDni() + " - Nombre: " + c.getNombre() + " - Apellido: " + c.getApellido());
//        }
//    }



}
