package Entities.Interface;

import Entities.Client;

import java.util.List;
import java.util.NoSuchElementException;

public class ICrudClientImpl implements ICrudClient {


    @Override
    public Client create(String name, String lastName, String dni) {
        Client client = new Client(name, lastName, dni);
        return client;
    }

    @Override
    public void update(Client client, List list, String dataToUpdate, String newData) {
        switch (dataToUpdate) {
            case "name":
                client.setName(newData);
                break;
            case "lastName":
                client.setLastName(newData);
                break;
            case "dni":
                client.setDni(newData);
                break;
            default:
                System.out.println("Invalid data");
        }

    }


    @Override
    public void listClients(List clients) {
        clients.forEach(System.out::println);
    }


    @Override
    public void delete(List list, Client client) {
        try {
            list.remove(client);
            System.out.println("Client deleted");
        } catch (NoSuchElementException e) {
            System.out.println("Client not found");
        }
    }


}
