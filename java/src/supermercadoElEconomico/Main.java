package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    //static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Factura> listaFacturas = new ArrayList<>();

    public static void main(String[] args) {

        ClienteImp cliImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();

        ArrayList<Item> listaItem = new ArrayList<>();

        int dni;
        Cliente c1 = new Cliente(38,"Lisandro","Lopez");
        Cliente c2 = new Cliente(35,"Lionel","Messi");
        Cliente c3 = new Cliente(32,"Diego","Milito");

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){

            System.out.println("\n\t1) Crear cliente");
            System.out.println("\t2) Eliminar cliente");
            System.out.println("\t3) Consultar clientes");
            System.out.println("\t4) Crear una factura");
            System.out.println("\t5) Salir");


            System.out.print("\nElija una de las opciones: ");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    cliImp.guardar(c1);
                    cliImp.guardar(c2);
                    cliImp.guardar(c3);
                    break;
                case 2:
                    cliImp.eliminar();
                    break;
                case 3:
                    cliImp.consultar();
                    break;
                case 5:
                    salir = true;
                    break;
                case 4:

                    Item it = new Item(1,"Shampoo",2,150);
                    Item it2 = new Item(2,"Jabón",5,85);
                    Item it3 = new Item(3,"Pasta dental",1,230);

                    listaItem.add(it);
                    listaItem.add(it2);
                    listaItem.add(it3);

                    Cliente c = null;

                    System.out.print("\n\tIngrese DNI cliente: ");
                    int dniTemp = sn.nextInt();
                    Cliente cliTemp = cliImp.buscar(dniTemp);
                    if(cliTemp == null){

                        System.out.print("\tIngrese el nombre: ");
                        String nombre = sn.next();
                        System.out.print("\tIngrese el apellido: ");
                        String apellido = sn.next();

                        c = new Cliente(dniTemp,nombre,apellido);
                        cliImp.guardar(c);
                    }else{
                        c = cliTemp;
                    }

                    Factura f = new Factura(c,listaItem);
                    f.calcularTotal();

                    facturaImp.guardar(f);
                    facturaImp.consultar();

                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }

    }

}
