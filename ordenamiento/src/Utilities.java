import Entities.Bill;
import Entities.Client;
import Entities.Interface.ICrudClientImpl;
import Entities.Item;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public boolean validateClient(List<Client> clients, String dni) {
        boolean result = false;

        for (Client client : clients) {
            if (client.getDni().equals(dni)) {
                result = true;
            }
        }
        return result;
    }

    public Client createClient() {

        Scanner sc = new Scanner(System.in);

        //Ask for the client data
        System.out.println("welcome, Type the client data \n");
        System.out.println("Please enter the client name: ");
        String clientName = sc.nextLine();

        System.out.println("Please enter the client last name: ");
        String clientLastName = sc.nextLine();

        System.out.println("PLease enter the client DNI: ");
        String clientDNI = sc.nextLine();


        //create the client
        Client client = new ICrudClientImpl().create(clientName, clientLastName, clientDNI);
        System.out.println("Client created \n");

        return client;
    }

    public void itemGenerator(List<Item> items) throws InterruptedException {
        //Ask for the items
        char option = 'y';
        Scanner sc = new Scanner(System.in);

        while (option == 'y') {
            System.out.println("Please enter the item name: ");
            String itemName = sc.next();

            System.out.println("Please enter the item price: ");
            double itemPrice = sc.nextDouble();

            System.out.println("Please enter the item quantity: ");
            int itemQuantity = sc.nextInt();

            //create the item
            Item item = new Item(itemName, itemQuantity, itemPrice);

            //add the item to the list
            items.add(item);

            //ask for another item
            System.out.println("Do you want to add another item? (y/n)");
            option = sc.next().charAt(0);
            if (option == 'n') {
                System.out.println("Thank you for shopping with us adding items to the bill");
                TimeUnit.SECONDS.sleep(2);
                break;
            }
        }
    }


}
