package com.company.repository;

import com.company.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImp implements CRUDRepository <Client> {
    List<Client> listClient = new ArrayList<>();

    @Override
    public void save(Client object) {
        listClient.add(object);
    }

    @Override
    public void showScreen() {
        for (Client c : listClient) {
            System.out.println("dni:" + c.getDni());
            System.out.println("Nombre:" + c.getName());
            System.out.println("Apellido:" + c.getLastName());
        }

    }

    @Override
    public Optional<Client> search(String id) {

        boolean flagShow = false;

        for (Client c : listClient) {
            if (c.getDni().equals(id)) {
                System.out.println("dni:" + c.getDni());
                System.out.println("Nombre:" + c.getName());
                System.out.println("Apellido:" + c.getLastName());
                flagShow = true;
                return Optional.of(c);
            }
        }
        System.out.println("No encontro el dni del cliente a mostrar");
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        Optional<Client> client = this.search(id);
        if (client.isEmpty()) {
            System.out.println("No encontro el dni del cliente a borrar");
        } else {
            listClient.remove(client.get());
            System.out.println("Cliente eliminado");
        }

    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public String toString() {
        return "ClientImp{" +
                "listClient=" + listClient +
                '}';
    }
}
