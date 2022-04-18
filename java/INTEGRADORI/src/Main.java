import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente;
        Cliente cliente1;
        Cliente cliente2;
        Cliente cliente3;
        Cliente loEncontre = null;

        ArrayList<Cliente> listClients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String dni = null;

        cliente = new Cliente("123456721", "Jose", "Sanchez");
        cliente1 = new Cliente("765432112", "Esteban", "Lopez");
        cliente2 = new Cliente("987654321", "Raul", "Martinez");
        cliente3 = new Cliente();

        listClients.add(cliente);
        listClients.add(cliente1);
        listClients.add(cliente2);

        for (Cliente c : listClients) {
            System.out.println(c);
        }

        System.out.println("------------------------------------");

        listClients.remove(cliente1);

        for (Cliente c : listClients) {
            System.out.println(c);
        }

        /**
         *
         * System.out.println("Ingrese un numero de dni");
         *         dni = sc.nextLine();
         *
         *          for (Cliente c : listClients) {
         *             if (dni.equalsIgnoreCase(c.getDni())) {
         *                 loEncontre = c;
         *             }
         *         }
         *
         *         if(loEncontre != null){
         *             System.out.println(loEncontre);
         *         } else {
         *             System.out.println( "No se encontro el cliente ");
         *         }
         * */


        Factura factura = new Factura(cliente3, 5000);
        factura.buscarCliente(listClients, cliente3);
        System.out.println("-----------------------------");
        System.out.println(listClients);



    }


    }






