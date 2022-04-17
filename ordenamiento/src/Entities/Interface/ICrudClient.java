package Entities.Interface;

import Entities.Bill;
import Entities.Client;

import java.util.List;

public interface ICrudClient<T extends Client> {

    public Client create(String name, String lastName, String dni);

    public void listClients(List<Client> clients);

    public void update(Client client, List<Client> clients, String dataToUpdate, String newData);

    public void delete(List<Client> clients, Client client);

}
