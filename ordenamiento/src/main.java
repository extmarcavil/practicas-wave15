import Entities.Bill;
import Entities.Client;
import Entities.Interface.ICrudClientImpl;
import Entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws InterruptedException {

        //variables
        Utilities util = new Utilities();
        Scanner sc = new Scanner(System.in);
        ICrudClientImpl crudClient = new ICrudClientImpl();
        char option = 'y';
//        Lists
//        client list
        List<Client> clients = new ArrayList<>();
//        items list
        List<Item> items = new ArrayList<>();
//        list of bills
        List<Bill> bills = new ArrayList<>();

        //Client
        Client client = null;

        //instances

        while (option == 'y') {

            int answer = 0;
            System.out.println("Welcome to the system, choose the action you want to do");

            System.out.println("1. Add client");
            System.out.println("2. Delete client");
            System.out.println("3. Update client");
            System.out.println("4. Show all clients");
            System.out.println("5. Add items");
            System.out.println("6. Print bill");
            System.out.println("7. Exit");

            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    //Ask for the client data and add it to the list
                    client = util.createClient();
                    clients.add(client);
                    break;
                case 2:
                    //Ask for the client id and delete it from the list
                    System.out.println("Enter the client DNI");
                    String dni = sc.next();
                    try {
                        Client clientToDelete = clients.stream()
                                .filter(c -> c.getDni().equals(dni))
                                .findAny().get();
                        crudClient.delete(clients, clientToDelete);
                    } catch (NoSuchElementException e) {
                        System.out.println("Client not found");
                    }

                    break;
                case 3:
                    //Ask for the client DNI and update all the client
                    System.out.println("Whats the data you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Last name");
                    System.out.println("3. DNI");

                    int updateAnswer = sc.nextInt();
                    String paramToUpdate = "";
                    switch (updateAnswer) {
                        case 1:
                            System.out.println("Enter the client new name");
                            paramToUpdate = sc.next();
                            crudClient.update(client, clients, "name", paramToUpdate);
                            break;
                        case 2:
                            System.out.println("Enter the client new last name");
                            paramToUpdate = sc.next();
                            crudClient.update(client, clients, "lastName", paramToUpdate);
                            break;
                        case 3:
                            System.out.println("Enter the client new DNI");
                            paramToUpdate = sc.next();
                            crudClient.update(client, clients, "dni", paramToUpdate);
                            break;
                        default:
                            System.out.println("Invalid option");

                    }
                    System.out.println("Client updated" + "\n" + client);

                    break;
                case 4:
                    //Show all the clients
                    clients.forEach(c -> {
                        System.out.println(c.toString());
                    });
                    break;
                case 5:
                    //Ask for the item data and add it to the list
                    util.itemGenerator(items);
                    break;
                case 6:
                    //create the bill
                    Bill bill = new Bill(client, items);

                    //Validate the client data and create the bill
                    if (util.validateClient(clients, client.getDni())) {

                        bills.add(bill);
                        bills.forEach(b -> b.calculateTotal());
                        bills.forEach(b -> b.printBill());

                    } else {
                        System.out.println("Client not found");
                    }
                    break;
                case 7:
                    System.out.println("Goodbye");
                    option = 'n';
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.println("Do you want to go back to the main menu? (y/n)");
            option = sc.next().charAt(0);
            if (option == 'n') {
                System.out.println("Goodbye, thank you for using our system!");
            }


        }
    }


}
