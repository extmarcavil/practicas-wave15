import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ClienteImp clientes = new ClienteImp();
        FacturaImp facturas = new FacturaImp();
        ProductoImp productos = new ProductoImp();

        Cliente c1 = new Cliente("23452345","Maria", "Algo");
        Cliente c2 = new Cliente("12452345","Juan", "Perez");
        Cliente c3 = new Cliente("43452345","Maria", "Cosa");

        clientes.guardar(c1);
        clientes.guardar(c2);
        clientes.guardar(c3);

        clientes.mostrar();
        clientes.eliminar("23452345");
        clientes.mostrar();

        Producto p1 = new Producto("AB12","Harina",2,3);
        Producto p2 = new Producto("AB13","Azucar",3,3);

        productos.guardar(p1);
        productos.guardar(p2);

        Factura f1 = new Factura("AC123",c1,productos.devolver());
        facturas.guardar(f1);
        facturas.mostrar();

//        System.out.println("Ingrese un dni");
//        Scanner scanner = new Scanner(System.in);
//        String dni = scanner.next();
//        System.out.println(dni);
//        Object[] clientePordni = clientes.stream().filter((cliente) -> cliente.getDni().equals(dni)).toArray();
//
//        if(clientePordni.length == 0){
//            System.out.println("No hay un cliente con ese dni");
//        }else{
//            System.out.println(clientePordni[0].toString());
//            }





        }




}
