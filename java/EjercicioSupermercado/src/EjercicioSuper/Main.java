package EjercicioSuper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(42885742, "Thiago", "Ramirez");
        Cliente cliente2 = new Cliente(43827312, "Agustin", "Rosas");
        Cliente cliente3 = new Cliente(40293821, "Matias", "Peña");

        List<Cliente> lista = new ArrayList<Cliente>();

        lista.add(cliente1);
        lista.add(cliente2);
        lista.add(cliente3);

        for (Cliente c : lista){
            System.out.println("\nDni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }

        lista.remove(1);

        for (Cliente c : lista){
            System.out.println("\nDni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }

        /*Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar: ");
        int dniBuscar = teclado.nextInt();

        for (Cliente c : lista){
            if(c.getDni() == dniBuscar){
                System.out.println("\nDni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                return;
            }
        }
        System.out.println("No se encontro el cliente en la lista");
*/




        //-----------------------------------------------------------------------------
        //EMPIEZA LA PARTE 2

        Producto producto1 = new Producto("41s2s","Chocolate",100,4);
        Producto producto2 = new Producto("418bsd8","Leche",200,3);
        Producto producto3 = new Producto("hdh17","Fideos",250,2);
        Producto producto4 = new Producto("11edsq","Manteca",130,2);

        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);

        double sumaTotal = 0;

        for (Producto pr : listaProductos){
            sumaTotal = sumaTotal + pr.getCantidadComprada() * pr.getCostoUnitario();
        }

        Factura factura1 = new Factura(42885742,listaProductos, sumaTotal);
        Factura factura2 = new Factura(42885743,listaProductos, sumaTotal);

        List<Factura> listaFacturas = new ArrayList<Factura>();

        for(Cliente c : lista){
            if (factura1.getDni() == c.getDni()) {
                System.out.println("El cliente se encuentra en la lista de clientes, por lo tanto se agrega la factura");
                }
            else{
                try {
                    System.out.println("El cliente no se encuentra en la lista de clientes, se dara de alta el cliente y se agrega la factura");
                    Scanner teclado1 = new Scanner(System.in);
                    System.out.println("Ingrese el nombre: ");
                    var nombre = teclado1.next();
                    System.out.println("Ingrese el apellido: ");
                    var apellido = teclado1.next();
                    var dni = factura2.getDni();
                    Cliente clienteNuevo = new Cliente(dni, nombre, apellido);
                    lista.add(clienteNuevo);
                    break;
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            listaFacturas.add(factura1);
            }
        for (Cliente c : lista){
            System.out.println("\nDNI: " + c.getDni());
            System.out.println("NOMBRE: " + c.getNombre());
            System.out.println("APELLIDO: " + c.getApellido());
        }

        }
}
