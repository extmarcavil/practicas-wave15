package com.company.repository;

import com.company.entity.Booking;
import com.company.entity.Client;
import com.company.entity.Locator;


import java.util.List;
import java.util.Map;

public class ClientRepository {
    private Map<String, Client> clients;
    private LocatorRepository locatorRepository;

    public ClientRepository(Map<String, Client> clients, LocatorRepository locatorRepository) {
        this.clients = clients;
        this.locatorRepository = locatorRepository;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.put(client.getDni(), client);
    }

    public Client getClient(String dni) {
        return clients.get(dni);
    }

    public List<Locator> getLocators(Client client){
        return this.locatorRepository.getLocatorsByClient(client);
    }

}
