package com.company.Repository;

import com.company.Client;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(Client client) {
        clientList.add(client);
    }

    public void showClientsInfo(){
        for (Client c: clientList){
            System.out.println(c);
        }
    }
}
