import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("31223767", "Jose", "Perez");
        Cliente c2 = new Cliente("38456342", "Facundo Nicolas", "Cardenas");
        Cliente c3 = new Cliente("14332778", "Pablo", "Gomez");

        List<Cliente> clientesList = new ArrayList<>();
        clientesList.add(c1);
        clientesList.add(c2);
        clientesList.add(c3);

        //clientesList.forEach(p -> System.out.println( p.toString()));
        //clientesList.remove(c1);
        //clientesList.forEach(p -> System.out.println( p.toString()));

        //Scanner input = new Scanner(System.in);
        //System.out.println("Ingrese el D.N.I del cliente para verificar que exista");
        //String nombreIngresado = input.nextLine();
        //Optional<Cliente> obtenido = clientesList.stream()
          //      .filter(c -> c.getDni().equals(nombreIngresado))
            //    .findFirst();

        //System.out.println(!obtenido.isPresent() ? "No existe el cliente con el D.N.I Ingresado" : obtenido.toString());

        List<Item> itemsList = new ArrayList<>();
        itemsList.add(new Item(1, "arroz", 2, 70));
        itemsList.add(new Item(2, "harina 0000", 1, 110));
        itemsList.add(new Item(3, "Led TV", 3, 25000));
        itemsList.add(new Item(4, "SmartWatch", 2, 3500));
        Factura newFactura = new Factura();
        newFactura.setItems(itemsList);
        double totalCompraCalculado = 0;
        newFactura.setCliente(c1);
        newFactura.setItems(itemsList);
        List<Factura> facturaList = new ArrayList<>();
        boolean estaEnLaLista = true;
        for (Cliente c : clientesList) {
            estaEnLaLista = true && c1.equals(c);
        }
        if (estaEnLaLista){
            newFactura.setCliente(c1);
        }
        else{
            Cliente newCliente = new Cliente("4455003", "Robustillo", "Perez");
            newFactura.setCliente(newCliente);
        }
        for (Item i : itemsList) {

               double sumaPorCantCompra = i.getCostoUnitario() * i.getCantidadComprada();
               totalCompraCalculado = totalCompraCalculado + sumaPorCantCompra;
        }
        newFactura.setTotalCompra(totalCompraCalculado);

        System.out.println(newFactura.toString());

    }
}
