package ejercicioIntegradorSupermercado;

/*
Supermercado “El económico”
Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas
de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación, consulta,
eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.
De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando un cliente hace
una compra contienen a un cliente, una lista de ítems y el total de la compra. De cada item o producto se guarda el
código, nombre, cantidad comprada y costo unitario.
Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos
sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

Parte I
Se necesita:
Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
Crear 3 clientes y guardarlos en una collection.
Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista,
mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.

Luego de la primera entrega satisfactoria, el Project Manager en conjunto con un analista funcional recabaron nuevos
requerimientos para llevar a cabo una segunda parte de desarrollo en un nuevo sprint. Éstos se citan a continuación:

Parte II
Crear una nueva factura.
Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes.
En caso de que no, el mismo deberá ser creado.
Será necesario crear una lista de items y asociarla a la factura creada.
El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer
la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.

Bonus
Con la finalidad de optimizar el código, se requiere la creación de una interfaz “CRUD” que sea capaz de contener,
mediante genéricos, todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.
Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el
punto anterior.
Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar
mediante el llamado de métodos.
*/


import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioIntegradorSupermercado {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Claudio", "Lopez");
        Cliente cliente2 = new Cliente(2, "Romina", "Costa");
        Cliente cliente3 = new Cliente(3, "Martina", "Ruiz");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        RepositorioCliente repoCliente = new RepositorioCliente(clientes);

        for (Cliente cliente : clientes) { System.out.println(cliente.toString()); }

        //Eliminando cliente en la posición 1 --> Romina
        clientes.remove(1);

        System.out.println();
        for (Cliente cliente : clientes) { System.out.println(cliente.toString()); }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el dni de un cliente para buscarlo en la lista: ");
        int dni = Integer.parseInt(scanner.nextLine());
        boolean encontrado = false;
        int cont = 0;
        do {
            if(clientes.get(cont).getDni() == dni) {
                encontrado = true;
                System.out.println("Cliente encontrado.");
                System.out.println(clientes.get(cont).toString());
            }

            cont++;
        } while (!encontrado && cont < clientes.size());

        //Otra manera de buscar
//        for (Cliente cliente : clientes) {
//            if (cliente.getDni() == dni) {
//                clientes.remove(cliente);
//                encontrado = true;
//                break;
//            }
//        }

        if (!encontrado)
            System.out.println("Cliente no encontrado");

        scanner.close();

        //Validar si un cliente existe
        //Producto

        //Factura factura = new Factura(cliente1, );

        //if(repoCliente.validarCliente(cliente1))

        //Factura factura = new Factura();
    }
}
