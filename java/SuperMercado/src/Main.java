import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteRepository;
import repository.FacturaRepository;
import repository.ItemRepository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteRepository cliImp = new ClienteRepository();
        FacturaRepository factImp = new FacturaRepository();
        ItemRepository itImp = new ItemRepository();

        ArrayList<Item> items = new ArrayList<Item>();

        Item item1 = new Item(123456789L, "Aguacate", 4,15.0);
        Item item2 = new Item(123456788L, "Pan", 5,5.0);
        Item item3 = new Item(123456787L, "Tortilla", 20,17.0);
        Item item4 = new Item(123456786L, "Limón", 15,65.0);

        itImp.save(item1);
        itImp.save(item2);
        itImp.save(item3);
        itImp.save(item4);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);


        Cliente cli1 = new Cliente(12365458L, "Luis", "Rodríguez");
        Cliente cli2 = new Cliente(65987456L, "Raul", "Bautista");
        Cliente cli3 = new Cliente(11254789L, "Alfredo", "Aguilar");

        cliImp.save(cli1);
        cliImp.mostrar();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);

        Factura factura = new Factura(1234554321L, cli2, items, items.stream().mapToDouble(item -> item.getCantidad()*item.getCostoUnitario()).sum());
        factImp.save(factura, cliImp);
        factImp.mostrar();
        cliImp.mostrar();
    }
}
